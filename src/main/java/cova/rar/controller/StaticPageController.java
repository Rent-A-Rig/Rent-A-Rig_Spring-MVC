package cova.rar.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.entities.User;
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

	@RequestMapping("/myAccount")
	public ModelAndView myAccount() {
		return new ModelAndView("myAccount");
	}
	
	@RequestMapping(value = {"/faq"})
	public ModelAndView FAQ() {
		return new ModelAndView("FAQ");
	}
	
	@RequestMapping("/writeCookie")
	public String writeCookies(HttpServletResponse response) {
		User user = new User();
		response.addCookie(new Cookie("firstnameCookie", user.getFirstname()));
		response.addCookie(new Cookie("lastnameCookie", user.getLastname()));
		response.addCookie(new Cookie("emailCookie", user.getEmail()));
		response.addCookie(new Cookie("phoneCookie", user.getPhone()));
		response.addCookie(new Cookie("usernameCookie", user.getUsername()));
		response.addCookie(new Cookie("passwordCookie", user.getPassword()));
		
		return "writeCookie";
	}

	
}