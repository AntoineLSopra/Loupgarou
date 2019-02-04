package fr.loupgarou.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import fr.loupgarou.dao.IDAOPersonnage;
import fr.loupgarou.model.Personnage;
import fr.loupgarou.projection.Views;


@RestController
@CrossOrigin("*") 
public class PersonnageRestController {
	
	@Autowired
	private IDAOPersonnage daoPersonnage;
	

	@GetMapping("/api/personnage")
	@JsonView(Views.Personnage.class)
	public List<Personnage> listeRest() {

		return this.daoPersonnage.findAll();
	}
	


}
