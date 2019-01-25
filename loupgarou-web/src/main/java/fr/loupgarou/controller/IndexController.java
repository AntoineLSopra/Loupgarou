package fr.loupgarou.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import fr.loupgarou.datajpa.IDAOUtilisateur;
import fr.loupgarou.model.Joueur;
import fr.loupgarou.model.Utilisateur;


@Controller
public class IndexController {


	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	@GetMapping("/index")
	public String index( Model model) {
		
		return "index";
	}
	
	@GetMapping("/")
	public String index2( Model model) {
		
		return "index";
	}
	
	
	@PostMapping("/connexion")
	public String postConnexion(@RequestParam String username, @RequestParam String password,  HttpSession session, Model model){
		
		int id = daoUtilisateur.findByUsername(username).getId();
		
		if (daoUtilisateur.findByUsername(username) != null 
				&& daoUtilisateur.findByUsername(username).getPassword().equals(password)
				&& daoUtilisateur.findByUsername(username).isAdmin() == false ){
			return "redirect:accueil/" + id;
		}
		
		if (daoUtilisateur.findByUsername(username) != null
				&& daoUtilisateur.findByUsername(username).getPassword().equals(password) 
				&& daoUtilisateur.findByUsername(username).isAdmin() == true ){
			return "redirect:personnages";
		}
		
		else {
			return "redirect:index";
		}
	}
	
	
	@PostMapping("/inscription")
	public String getInscription(@Valid @ModelAttribute Joueur joueur, BindingResult result, HttpSession session, Model model){
		
			model.addAttribute("joueur", daoUtilisateur.save(joueur));

		return "redirect:index";
	}
	
//	
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
