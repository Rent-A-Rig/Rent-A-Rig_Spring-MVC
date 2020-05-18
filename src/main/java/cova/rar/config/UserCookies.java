package cova.rar.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cova.rar.entities.User;

@WebServlet("/UserInfo")
public class UserCookies extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserCookies() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		HttpSession session = request.getSession();
		
		if (user.getFirstname().equals("")) {
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		}

		else if (!user.equals(null)) {
			// set Session Attribute & Make Cookies!
			session.setAttribute("user", user);
			session.setAttribute("signedin", "yes");
		}

		String username = request.getParameter("username");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + username + "</h1>");
		writer.close();

		// username cookie
		Cookie usernamecookie = new Cookie("username", user.getUsername());
		usernamecookie.setPath("/");
		usernamecookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(usernamecookie);

		// first name cookie
		Cookie firstNameCookie = new Cookie("firstName", user.getFirstname());
		firstNameCookie.setPath("/");
		firstNameCookie.setMaxAge(60 * 60 * 24 * 2);
		response.addCookie(firstNameCookie);

		// last name cookie
		Cookie lastNameCookie = new Cookie("lastName", user.getLastname());
		lastNameCookie.setPath("/");
		lastNameCookie.setMaxAge(60 * 60 * 24 * 2);
		response.addCookie(lastNameCookie);

		// phone number cookie
		Cookie phoneCookie = new Cookie("phone", user.getPhone());
		phoneCookie.setPath("/");
		phoneCookie.setMaxAge(60 * 60 * 24 * 2);
		response.addCookie(phoneCookie);

		// email address cookie
		Cookie emailCookie = new Cookie("email", user.getEmail());
		emailCookie.setPath("/");
		emailCookie.setMaxAge(60 * 60 * 24 * 2);
		response.addCookie(emailCookie);

		// password cookie
		Cookie passwordCookie = new Cookie("password", user.getPassword());
		passwordCookie.setPath("/");
		passwordCookie.setMaxAge(60 * 60 * 24 * 2);
		response.addCookie(passwordCookie);

		// address cookie -> Do we need a shipping and a billing or just a generic
		// address???
		Cookie addressCookie = new Cookie("address", user.getAddress());
		addressCookie.setPath("/");
		addressCookie.setMaxAge(60 * 60 * 24 * 2);
		response.addCookie(addressCookie);

//
//		Cookie[] cookies = request.getCookies();
//
//		for (Cookie aCookie : cookies) {
//			String name = aCookie.getName();
//			String value = aCookie.getValue();
//
//			writer.println(name + " = " + value);
//		}

	}
}
