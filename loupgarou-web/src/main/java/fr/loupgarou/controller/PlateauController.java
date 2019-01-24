package fr.loupgarou.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.loupgarou.datajpa.IDAOParticipation;
import fr.loupgarou.datajpa.IDAOPartie;
import fr.loupgarou.datajpa.IDAOPersonnage;
import fr.loupgarou.datajpa.IDAOPouvoir;
import fr.loupgarou.datajpa.IDAOUtilisateur;
import fr.loupgarou.model.Partie;


@Controller
public class PlateauController {

	
	@Autowired
	private IDAOPartie daoPartie;
	
	@Autowired
	private IDAOParticipation daoParticipation;
	

	@GetMapping("/plateau/{id}")
	public String rejoindrePartie(@PathVariable Integer id, HttpSession session, Model model) {
			

		model.addAttribute("participations", daoParticipation.findByPartieId(id));

		model.addAttribute("partie", daoPartie.findById(id).get());
		
		return "plateau";
		
	}
	
	
	@GetMapping("/plateau/{id}/supprimer/{idParticipation}")
	public String supprimerProduit(@PathVariable Integer id, @PathVariable Integer idParticipation, HttpSession session, Model model) {
			
		daoParticipation.deleteById(idParticipation);
		
		
		
		return "redirect:/plateau/{id}";
		
	}
//	
//	@GetMapping("/ajout")
//	public String ajoutProduit(Model model) {
//		
//		model.addAttribute("fournisseurs", daoFournisseur.findAll());
//		
//		return "ajout";
//		
//	}
//	
//	@PostMapping("/ajout")
//	public String ajoutProduit2(@Valid @ModelAttribute Produit produit, BindingResult result, HttpSession session, Model model) {
//		
//		if (result.hasErrors()) {
//			
//			model.addAttribute("fournisseurs", daoFournisseur.findAll());
//			
//			return "ajout";
//		}
//		
//		model.addAttribute("produit", daoProduit.save(produit));
//		
//
//		return "redirect:/produit";
//	}
//	
//	
//	@GetMapping("/supprimer/{id}")
//	public String supprimerProduit(@PathVariable Integer id, HttpSession session, Model model) {
//			
//		
//		daoProduit.deleteById(id);
//		
//		return "redirect:/produit";
//		
//	}
//
//	@GetMapping("/editer/{id}")
//	public String modifierProduit(@PathVariable Integer id, HttpSession session, Model model) {
//			
//		
//		
//		daoProduit.findById(id).get();
//		
//		return "editer";
//		
//	}
//	
//	@PostMapping("/editer/{id}")
//	public String modifierProduit2(@ModelAttribute Produit produit, HttpSession session, Model model) {
//			
//		
//		model.addAttribute("produit", daoProduit.save(produit));
//
//		return "redirect:/produit";
//		
//	}
	
	
//	@GetMapping( { "/produit/{id}"})
//	public String produit2( @PathVariable Integer id, HttpSession session, Model model) {
//		
//		
//		model.addAttribute("id", id * 2);
//
//		return "produit";
//	}
	
	
}
