package org.GestionBiblio.Controller;


import org.GestionBiblio.Model.Livre;
import org.GestionBiblio.Repository.CategorieRepository;
import org.GestionBiblio.Repository.LivreRepository;
import org.GestionBiblio.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ApplicationController {
	
	
	@Autowired
	UserRepository userR;
	
	
	@Autowired
	LivreRepository livreR;
	
	@Autowired
	CategorieRepository categorieR;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/Index")
	
	public String home(Model model)
	{
		
		model.addAttribute("users", userR.findAll());
		model.addAttribute("livres", livreR.findAll());
		model.addAttribute("categories", categorieR.findAll());
		
		return "Index";
	}
	
	
}
