package org.GestionBiblio.Controller;

import java.util.List;





import org.GestionBiblio.Model.User;
import org.GestionBiblio.Repository.RoleRepository;
import org.GestionBiblio.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	RoleRepository rolesR;
	
	
	
	
	
	@GetMapping("/User")
	
	public String viewHomePage(Model model) {
	    List<User> listUser = userService.listAll();
	    model.addAttribute("listuser", listUser);
	     
	    return "Users/User";
	}
	
	// GET  /users/new			- the form to fill the data for a new user
		@RequestMapping(value="/SignUp", method=RequestMethod.GET)
		public String newLivre(Model model) {
			model.addAttribute("user", new User());
			return "SignUp";
		}
		
		

		
		
	
	@RequestMapping(value = "/saveuser", method= RequestMethod.POST)
	public String enregistreruser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/saver", method= RequestMethod.POST)
	public String enregistrerS(@ModelAttribute("user") User user) {
		userService.saver(user);
		return "redirect:/User";
	}
	
	
	
	
	
	@RequestMapping("Users/modifieruser/{userId}")
	public ModelAndView modifieruser(@PathVariable(name = "userId") Long userId, Model model) {
		ModelAndView mod = new ModelAndView("Users/modifier_user");
		User user = userService.get(userId);
		mod.addObject("user", user);
	    model.addAttribute("role", rolesR.findAll());
		return mod;
	}
	
	@RequestMapping("Users/supprimeruser/{userId}")
	public String supprimerUser(@PathVariable(name = "userId") Long userId) {
		userService.delete(userId);
		return "redirect:/User";
	}
	
	
	
	


	

}
