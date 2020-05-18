package cova.rar.controller;
import javax.validation.Valid;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import cova.rar.entities.User;
import cova.rar.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	public UserService userService;
	
	// go to registration page
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public ModelAndView showResgister(HttpServletRequest request, HttpServletResponse response) {
//		
//		ModelAndView mv = new ModelAndView("register");
//		mv.addObject("user", new User());
//		
//		return mv;
//	}
//	
//	// click on register button
//	@PostMapping(value = "/registerProcess")
//	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
//			  @Valid @ModelAttribute("user") User user, BindingResult result) {
//		ModelAndView model;
//	    if (result.hasErrors()) {
//	        model = new ModelAndView("user", result.getModel());
//		}
//		
//		userService.register(user);
//		return new ModelAndView("welcome", "firstname", user.getFirstname());
//	}
	
	
	
//	//@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/results").setViewName("results");
//	}

	@GetMapping("/register")
	//@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, Object> model) {
		User user = new User();    
        model.put("user", user);
        
		return "register";
	}

	
	// click on register button
	@PostMapping(value = "/registerProcess")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("user") User user) {
		
		userService.register(user);
		return new ModelAndView("welcome", "firstname", user.getFirstname());

	}
}
