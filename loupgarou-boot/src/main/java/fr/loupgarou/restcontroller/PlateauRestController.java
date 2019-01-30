package fr.loupgarou.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import fr.loupgarou.dao.IDAOParticipation;
import fr.loupgarou.model.Participation;
import fr.loupgarou.projection.Views;


@RestController
@CrossOrigin("*") 
public class PlateauRestController {
	
	@Autowired
	private IDAOParticipation daoParticipation;
	

	@DeleteMapping("/api/plateau/{id}/supprimer/{idParticipation}")
	@JsonView(Views.Participation.class)
	public String deleteById(@PathVariable int idParticipation) {
		this.daoParticipation.deleteById(idParticipation);
		return "Suppression de la participation n°" + idParticipation;
	}
	
	
}
