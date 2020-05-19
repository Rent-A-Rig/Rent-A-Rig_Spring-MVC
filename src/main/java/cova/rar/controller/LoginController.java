package cova.rar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.entities.Login;
import cova.rar.entities.User;
import cova.rar.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	// go to login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("login", new Login());
		return mv;
	}
	
	// click on login
	/*
	 * @RequestMapping(value = "loginProcess", method = RequestMethod.GET) public
	 * ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse
	 * response,
	 * 
	 * @ModelAttribute("login") Login login) {
	 * 
	 * ModelAndView mv = null;
	 * 
	 * User user = userService.validateUser(login);
	 * 
	 * if (null != user) { mv = new ModelAndView("welcome");
	 * mv.addObject("firstName", user.getFirstname());
	 * 
	 * } else { mv = new ModelAndView("login"); mv.addObject("message",
	 * "Username or Password is incorrect!"); }
	 * 
	 * 
	 * return mv; }
	 */
	
	@PostMapping("/loginProcess")
	public String loginProcess(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("has error!");
			return "login";
		}

		return "welcome";
	}

}
