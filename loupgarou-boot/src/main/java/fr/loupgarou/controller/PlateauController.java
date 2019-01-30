package fr.loupgarou.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.loupgarou.dao.IDAOParticipation;
import fr.loupgarou.dao.IDAOPartie;
import fr.loupgarou.dao.IDAOUtilisateur;


@Controller
public class PlateauController {

	
	@Autowired
	private IDAOPartie daoPartie;
	
	@Autowired
	private IDAOParticipation daoParticipation;
	
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	
	@GetMapping("{idJoueur}/plateau/{id}")
	public String rejoindrePartie(@PathVariable Integer id, @PathVariable Integer idJoueur, HttpSession session, Model model) {
			
		model.addAttribute("utilisateur", daoUtilisateur.findById(idJoueur).get());  
		
		model.addAttribute("participations", daoParticipation.findByPartieId(id));

		model.addAttribute("partie", daoPartie.findById(id).get());
		
		return "plateau";
		
	}
	
	
	@GetMapping("/plateau/{id}/supprimer/{idParticipation}")
	public String supprimerProduit(@PathVariable Integer id, @PathVariable Integer idParticipation, HttpSession session, Model model) {
			
		daoParticipation.deleteById(idParticipation);
		
		return "redirect:/plateau/{id}";
		
	}
	
	

	
}
