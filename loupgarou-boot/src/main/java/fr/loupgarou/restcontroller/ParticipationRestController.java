package fr.loupgarou.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import fr.loupgarou.dao.IDAOParticipation;
import fr.loupgarou.model.Participation;
import fr.loupgarou.projection.Views;


@RestController
@CrossOrigin("*") 
public class ParticipationRestController {
	
	@Autowired
	private IDAOParticipation daoParticipation;
	

	

	@GetMapping("/api/participation/{idPartie}")
	@JsonView(Views.Participation.class)
	public List<Participation> listeRest(@PathVariable int idPartie) {

		return this.daoParticipation.findByPartieId(idPartie);
	}
	
	
	
	
}
