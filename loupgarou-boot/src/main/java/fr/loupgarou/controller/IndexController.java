package fr.loupgarou.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.loupgarou.dao.IDAOUtilisateur;
import fr.loupgarou.model.Joueur;



@Controller
public class IndexController {
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	
	@PostMapping("/inscription")
	public String getInscription(@ModelAttribute Joueur joueur, BindingResult result, HttpSession session, Model model){
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//			String a = bcrypt.encode(joueur.getPassword());
//			joueur.setPassword(a);
			
		System.out.println("xfdbfgvcg");
			joueur.setPassword(bcrypt.encode(joueur.getPassword()));
			daoUtilisateur.save(joueur);
		return "redirect:/index";
	}
	
}
