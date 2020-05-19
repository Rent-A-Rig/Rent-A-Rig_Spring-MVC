package cova.rar.service;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cova.rar.entities.User;

public class CookieMonster {
	
	
	public void setUserCookie(User user, HttpServletResponse response) {

		// username cookie ** will be used to get data from DB for user
		Cookie usernamecookie = new Cookie("username", user.getUsername());
		usernamecookie.setPath("/");
		usernamecookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(usernamecookie);

	}
	
	public void setLoginCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		Cookie loginCookie = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login")) {
				loginCookie = cookie;
			}
		}
		
		if (null == loginCookie) {
			loginCookie = new Cookie("login", "true");
			loginCookie.setPath("/");
			loginCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(loginCookie);
			
		}
		else if (loginCookie.getValue().equals("false")) {
			loginCookie = new Cookie("login", "true");
			loginCookie.setPath("/");
			loginCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(loginCookie);
		}
		
	}
	
	public void setLogoutCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		Cookie loginCookie = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login")) {
				loginCookie = cookie;
			}
		}
		
		if (null == loginCookie || loginCookie.getValue().equals("true")) {
			loginCookie = new Cookie("login", "false");
			loginCookie.setPath("/");
			loginCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(loginCookie);
		}
		
	}
	
	public boolean isLoggedIn(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		Cookie loginCookie = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login")) {
				loginCookie = cookie;
			}
		}
		
		if (null == loginCookie || loginCookie.getValue().equals("false")) {
			return false;
		}
		else {
			return true;
		}
		
	}

	public void initLogin(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] cookies = request.getCookies();
		Cookie loginCookie = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login")) {
				loginCookie = cookie;
			}
		}
		
		if (null == loginCookie) {
			loginCookie = new Cookie("login", "false");
			loginCookie.setPath("/");
			loginCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(loginCookie);
			
		}

	}

}
