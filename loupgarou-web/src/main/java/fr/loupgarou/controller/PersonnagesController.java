package fr.loupgarou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.loupgarou.datajpa.IDAOPersonnage;

@Controller
@RequestMapping("/personnages")
public class PersonnagesController {
	@Autowired
	private IDAOPersonnage daoPersonnage;
	
	@GetMapping
	public String afficherPersonnages(Model model){
		model.addAttribute("personnages", daoPersonnage.findAll());
		return "personnages";
	}

}
