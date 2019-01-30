package fr.loupgarou.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.loupgarou.dao.IDAOParticipation;
import fr.loupgarou.dao.IDAOPartie;
import fr.loupgarou.model.Participation;
import fr.loupgarou.projection.Views;


@RestController
@CrossOrigin("*") 
public class PlateauRestController {
	
	@Autowired
	private IDAOParticipation daoParticipation;
	


	@DeleteMapping("/plateau/{id}/supprimer/{idParticipation}")
	@JsonView(Views.Participation.class)
	public Participation deleteById(@PathVariable int idParticipation, @PathVariable int id, @RequestBody Participation participation) {
		this.daoParticipation.deleteById(idParticipation);
		return participation;
	}
	
	
	
	
//	@GetMapping("/plateau/{id}/supprimer/{idParticipation}")
//	public String supprimerProduit(@PathVariable Integer id, @PathVariable Integer idParticipation, HttpSession session, Model model) {	
//		daoParticipation.deleteById(idParticipation);
//		return "redirect:/plateau/{id}";
//	}

	
}
