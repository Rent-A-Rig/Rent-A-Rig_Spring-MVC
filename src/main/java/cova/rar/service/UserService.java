package cova.rar.service;

import cova.rar.dao.UserDao;
import cova.rar.entities.Login;
import cova.rar.entities.User;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	@Autowired
	public UserDao userDao;

	public int register(User user) {
		return userDao.register(user);
	}

	public Login validateUser(Login login) {
		return userDao.validateUser(login);
	}

	public User setUserCookies(User user, HttpServletResponse response) {

		CookieMonster cookieMonster = new CookieMonster();
		cookieMonster.setCookie("usernameCookie", user.getUsername(), response);
		cookieMonster.setCookie("firstnameCookie", user.getFirstname(), response);
		cookieMonster.setCookie("lastnameCookie", user.getLastname(), response);
		cookieMonster.setCookie("emailcookie", user.getEmail(), response);
		cookieMonster.setCookie("phonecookie", user.getPhone(), response);
		cookieMonster.setCookie("passwordCookie", user.getPassword(), response);

		return user;
	}

}
