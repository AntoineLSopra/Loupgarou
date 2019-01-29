
package fr.loupgarou.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.loupgarou.dao.IDAOPersonnage;
import fr.loupgarou.dao.IDAOPouvoir;
import fr.loupgarou.model.Personnage;
import fr.loupgarou.model.Pouvoir;

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
	
	@GetMapping("/ajouter")
	public String ajouterPersonnage(Model model) {
		model.addAttribute("pouvoirs", daoPouvoir.findAll());
		return "perso-edit";
	}
	
	//A FAIRE : ERREUR SI 2 POUVOIRS IDENTIQUES
	@PostMapping("/ajouter")
	public String envoyerPersonnage(@RequestParam Integer monIdPouvoir, @RequestParam Integer monIdPouvoir2,
			@RequestParam Integer monIdPouvoir3, @ModelAttribute Personnage personnage, Model model) {
		personnage.setPouvoirs(new ArrayList<Pouvoir>());
		Pouvoir pouv = null;
		Pouvoir pouv2 = null;
		Pouvoir pouv3 = null;//daoPouvoir.findById(monIdPouvoir3).get();
		
		if (monIdPouvoir3 > 0) {
			pouv3 = daoPouvoir.findById(monIdPouvoir3).get();
		}
		
		if (monIdPouvoir2 > 0) {
			pouv2 = daoPouvoir.findById(monIdPouvoir2).get();
		}
		
		if (monIdPouvoir > 0) {
			pouv = daoPouvoir.findById(monIdPouvoir).get();
		}
		personnage.getPouvoirs().add(pouv);
		personnage.getPouvoirs().add(pouv2);
		personnage.getPouvoirs().add(pouv3);
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
		model.addAttribute("pouvoirs", daoPouvoir.findAll());
		model.addAttribute("personnage", daoPersonnage.findById(id).get());
		return "perso-edit";
	}
	
	@PostMapping("/editer/{id}")
	public String editerPersonnage(@RequestParam Integer monIdPouvoir, @RequestParam Integer monIdPouvoir2,
			@RequestParam Integer monIdPouvoir3, @PathVariable Integer id, @ModelAttribute Personnage personnage) {
		
		personnage.setId(id);
		personnage.setPouvoirs(new ArrayList<Pouvoir>());
		Pouvoir pouv = null;
		Pouvoir pouv2 = null;
		Pouvoir pouv3 = null;//daoPouvoir.findById(monIdPouvoir3).get();
		
		if (monIdPouvoir3 > 0) {
			pouv3 = daoPouvoir.findById(monIdPouvoir3).get();
		}
		
		if (monIdPouvoir2 > 0) {
			pouv2 = daoPouvoir.findById(monIdPouvoir2).get();
		}
		
		if (monIdPouvoir > 0) {
			pouv = daoPouvoir.findById(monIdPouvoir).get();
		}
		
		
		personnage.getPouvoirs().add(pouv);
		personnage.getPouvoirs().add(pouv2);
		personnage.getPouvoirs().add(pouv3);
		
		daoPersonnage.save(personnage);
		return "redirect:/personnages";
	}

}
