package fr.loupgarou.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.loupgarou.dao.IDAOUtilisateur;
import fr.loupgarou.model.Utilisateur;


@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	
	 @RequestMapping(value = "/perform_login", method = RequestMethod.GET)
	    @ResponseBody
	    public String currentUserName(Utilisateur utilisateur) {  
		 return utilisateur.getUsername();
	    }
	
	
	
}
