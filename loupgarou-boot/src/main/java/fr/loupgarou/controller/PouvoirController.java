package fr.loupgarou.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.loupgarou.dao.IDAOPersonnage;
import fr.loupgarou.dao.IDAOPouvoir;
import fr.loupgarou.model.Pouvoir;
import fr.loupgarou.security.IsAdmin;

@Controller
@IsAdmin
@RequestMapping("/pouvoir")

public class PouvoirController {
	@Autowired
	private IDAOPersonnage daoPersonnage;
	
	@Autowired
	private IDAOPouvoir daoPouvoir;
	
	@GetMapping
	public String afficherPouvoirs(Model model){
		model.addAttribute("pouvoirs", daoPouvoir.findAll());
		
		//PAS DE FINDALL
		//A LA PLACE : UNE METHODE QUI RETOURNE UNE LISTE DE PERSO AVEC LES POUVOIRS
		// -> LEFT JOIN FETCH JPA-QUERIES
		
		return "pouvoir";
	}
	
	@GetMapping("/ajouter")
	public String ajouterPouvoir(Model model) {
		model.addAttribute("pouvoirs", daoPouvoir.findAll());
		return "pouv-edit";
	}
	
	@PostMapping("/ajouter")
	public String ajouterPouvoir(@ModelAttribute Pouvoir pouvoir) {
		daoPouvoir.save(pouvoir);
		return "redirect:/pouvoir";
	}
	
	@GetMapping("/supprimer/{id}")
	public String supprimerPouvoir(@PathVariable Integer id, HttpSession session, Model model) {
		daoPouvoir.deleteById(id);
		return "redirect:/pouvoir";
	}
	
	@GetMapping("/editer/{id}")
	public String editerPouvoir(@PathVariable Integer id, Model model) {
		model.addAttribute("pouvoir", daoPouvoir.findById(id).get());
		return "pouv-edit";
	}
	
	@PostMapping("/editer/{id}")
	public String editerPouvoir(@PathVariable Integer id, @ModelAttribute Pouvoir pouvoir) {
		pouvoir.setId(id);
		daoPouvoir.save(pouvoir);
		return "redirect:/pouvoir";
	}

}

