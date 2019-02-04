package fr.loupgarou.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import fr.loupgarou.dao.IDAOParticipation;
import fr.loupgarou.dao.IDAOPersonnage;
import fr.loupgarou.model.Participation;
import fr.loupgarou.model.Personnage;
import fr.loupgarou.projection.Views;


@RestController
@CrossOrigin("*") 
public class PlateauRestController {
	
	@Autowired
	private IDAOParticipation daoParticipation;
	
	@Autowired
	private IDAOPersonnage daoPersonnage;
	

	@GetMapping("/api/plateau")
	@JsonView(Views.Personnage.class)
	public List<Personnage> listeRest() {

		return this.daoPersonnage.findAll();
	}

	@DeleteMapping("/api/plateau/{id}/supprimer/{idParticipation}")
	@JsonView(Views.Participation.class)
	public String deleteById(@PathVariable int idParticipation) {
		this.daoParticipation.deleteById(idParticipation);
		return "Suppression de la participation n°" + idParticipation;
	}
	
	
}
