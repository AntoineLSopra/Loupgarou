package fr.loupgarou.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController  {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home( @RequestParam String username,HttpSession session, Model model) {
		
		model.addAttribute("utilisateur", username);

		return "home";
	}
	
}