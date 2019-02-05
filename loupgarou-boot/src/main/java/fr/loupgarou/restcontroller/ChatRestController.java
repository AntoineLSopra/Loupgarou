package fr.loupgarou.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;

import fr.loupgarou.dao.IDAOMessage;
import fr.loupgarou.dao.IDAOPersonnage;
import fr.loupgarou.model.Message;
import fr.loupgarou.model.Personnage;
import fr.loupgarou.projection.Views;


@RestController
@CrossOrigin("*") 
public class ChatRestController {
	
	@Autowired
	private IDAOMessage daoMessage;
	

	@GetMapping("/api/chat")
	@JsonView(Views.Chat.class)
	public List<Message> listeRest() {
		return this.daoMessage.findAll();
	}
	


}
