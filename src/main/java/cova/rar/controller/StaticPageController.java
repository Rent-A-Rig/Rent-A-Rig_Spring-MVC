package cova.rar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.service.CookieMonster;

@Controller

public class StaticPageController {
	
	@Autowired
	CookieMonster cookieMonster;
	
	// map requestmappings to static pages
	@RequestMapping(value= {"/home"})
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value= {"/", ""})
	public ModelAndView firstVisit(HttpServletRequest request, HttpServletResponse response) {
		// check user cookie. If there is no user cookie then make new one with empty string
		if (!cookieMonster.isLoggedIn(request)) {
			cookieMonster.initLogin(request, response);
		}
		return new ModelAndView("home");
	}

	@RequestMapping(value = {"/myAccount"})
	public ModelAndView myAccount() {
		return new ModelAndView("myAccount");
	}

}
