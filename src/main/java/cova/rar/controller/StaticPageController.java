package cova.rar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class StaticPageController {
	
	// map requestmappings to static pages
	@RequestMapping(value= {"/home"})
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value= {"/", ""})
	public ModelAndView firstVisit() {
		// check user cookie. If there is no user cookie then make new one with empty string
		// usercookie = ""
		return new ModelAndView("home");
	}

	@RequestMapping(value = {"/myAccount"})
	public ModelAndView myAccount() {
		return new ModelAndView("myAccount");
	}

}
