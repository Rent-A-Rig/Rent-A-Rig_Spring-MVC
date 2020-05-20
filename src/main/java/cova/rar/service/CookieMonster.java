package cova.rar.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cova.rar.entities.User;

public class CookieMonster {
	
	
	public boolean isLoggedIn(HttpServletRequest request) {

		Cookie loginCookie = getCookie("login", request);
		
		if (null == loginCookie || loginCookie.getValue().equals("false")) {
			return false;
		}
		else {
			return true;
		}
		
	}

	public void initLogin(HttpServletRequest request, HttpServletResponse response) {
		// init the login and session cookies
		
		Cookie loginCookie = getCookie("login", request);
		Cookie sessionCookie = getCookie("session", request);
		String sessionID = request.getSession().getId();
		if (null == loginCookie) {
			setCookie("login", "false", response);
		}
		if (null == sessionCookie || !sessionID.equals(sessionCookie.getValue())) {
			setCookie("session", request.getSession().getId(), response);		
		}
		

	}
	
	public void setCookie(String name, String value, HttpServletResponse response) {
		
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(cookie);
		
	}
	
	public Cookie getCookie(String cookieName, HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();

		if (null != cookies) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) {
					return c;
				}
			}
		}
		
		return null;
	}

}
 