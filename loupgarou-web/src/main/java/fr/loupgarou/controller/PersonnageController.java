package fr.loupgarou.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.loupgarou.datajpa.IDAOPersonnage;
import fr.loupgarou.datajpa.IDAOPouvoir;
import fr.loupgarou.model.Personnage;

@Controller
@RequestMapping("/personnages")
public class PersonnageController {
	@Autowired
	private IDAOPersonnage daoPersonnage;
	
	@Autowired
	private IDAOPouvoir daoPouvoir;
	
	@GetMapping
	public String afficherPersonnages(Model model){
		
		//PAS DE FINDALL
		//A LA PLACE : UNE METHODE QUI RETOURNE UNE LISTE DE PERSO AVEC LES POUVOIRS
		// -> LEFT JOIN FETCH JPA-QUERIES
		model.addAttribute("personnages", daoPersonnage.trouveravecPouvoirs());
		
		return "personnages";
	}
	
	@GetMapping("/ajouter/{id}")
	public String ajouterPersonnage(Model model) {
		model.addAttribute("pouvoirs", daoPouvoir.findAll());
		return "ajouter";
	}
	
	@PostMapping
	public String ajouterPersonnage(@ModelAttribute Personnage personnage) {
		daoPersonnage.save(personnage);
		return "redirect:/personnages";
	}
	
	@GetMapping("/supprimer/{id}")
	public String supprimerPersonnage(@PathVariable Integer id, HttpSession session, Model model) {
		daoPersonnage.deleteById(id);
		return "redirect:/personnages";
	}
	
	@GetMapping("/editer/{id}")
	public String editerPersonnage(@PathVariable Integer id, 
 Model model) {
		model.addAttribute("produit", daoPersonnage.findById(id).get());
		return "editer";
	}
	
	@PostMapping("/editer/{id}")
	public String editerPersonnage(@PathVariable Integer id, @ModelAttribute Personnage personnage) {
		personnage.setId(id);
		daoPersonnage.save(personnage);
		return "redirect:/personnages";
	}

}
