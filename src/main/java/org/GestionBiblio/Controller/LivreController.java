package org.GestionBiblio.Controller;


import java.util.List;



import org.GestionBiblio.Model.Livre;
import org.GestionBiblio.Repository.CategorieRepository;
import org.GestionBiblio.Service.LivreService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;




@Controller
@ComponentScan

@RequestMapping("/")
public class LivreController {
	
	
	
	@Autowired
	LivreService livreService;
	
	
	
	@Autowired
	CategorieRepository categorieR;
	
	
	
	@GetMapping("/livres")
	public String viewHomePage(Model model) {
	    List<Livre> listLivre = livreService.listAll();
	    model.addAttribute("listLivre", listLivre);
	    model.addAttribute("categories", categorieR.findAll());
	    return "Livres/livres";
	}
	@GetMapping("/livreliste")
	public String view(Model model) {
		List<Livre> listLivre = livreService.listAll();
		model.addAttribute("listLivre", listLivre);
		return "Livres/livreliste";
		
	}
	
	@GetMapping("/nouveau")
	public String affichernouveaupagelivre(Model model) {
		Livre livre = new Livre();
		model.addAttribute("livre", livre);
		model.addAttribute("categories", categorieR.findAll());
		
		return "Livres/nouveau_livre";
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST)
	public String enregistrerlivre(@ModelAttribute("livre") Livre livre) {
		livreService.save(livre);
		return "redirect:livres";
	}
	/*
	@PostMapping(value = "/save")
	public String enregistrerlivre(@ModelAttribute("livre") Livre livrel, @RequestParam("filee") MultipartFile filee) {
		livreService.save(livrel, filee);
		return "redirect:livres";
	}*/
	
	@GetMapping("Livres/modifier/{livreId}")
	public ModelAndView modifierlivre(@PathVariable(name = "livreId") Long livreId, Model model) {
		ModelAndView mod = new ModelAndView("Livres/modifier_livre");
		Livre livre = livreService.get(livreId);
		mod.addObject("livre", livre);
		model.addAttribute("categories", categorieR.findAll());
		return mod;
	}
	
	@GetMapping("Livres/supprimer/{livreId}")
	public String supprimerLivre(@PathVariable(name = "livreId") Long livreId) {
		livreService.delete(livreId);
		return "redirect:/livres";
	}
	@GetMapping(value="/")
	public String home() {
		return "redirect:/Index";
	}
	
	
	
	
}
