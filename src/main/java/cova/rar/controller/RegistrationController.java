package cova.rar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.entities.User;
import cova.rar.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	public UserService userService;
	
	// go to registration page
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showResgister(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new User());
		
		return mv;
	}
	
	// click on register button
	@PostMapping(value = "/registerProcess")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("user") User user) {
		
		userService.register(user);
		return new ModelAndView("welcome", "firstname", user.getFirstname());
	}
}
