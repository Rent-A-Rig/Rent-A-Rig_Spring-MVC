package cova.rar.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cova.rar.entities.User;

@WebServlet("/UserInfo")
public class UserCookies extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserCookies() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + username + "</h1>");
		writer.close();

		Cookie UNcookie = new Cookie("username", request.getParameter("userName"));
		Cookie PWcookie = new Cookie("password", request.getParameter("password"));
		Cookie firstNameCookie = new Cookie("firstName", request.getParameter("firstName"));
		Cookie lastNameCookie = new Cookie("lastName", request.getParameter("lastName"));
		Cookie phoneCookie = new Cookie("phone", request.getParameter("phone"));
		Cookie emailCookie = new Cookie("email", request.getParameter("email"));
		Cookie passwordCookie = new Cookie("password", request.getParameter("password"));

		response.addCookie(UNcookie);
		response.addCookie(PWcookie);
		response.addCookie(firstNameCookie);
		response.addCookie(lastNameCookie);
		response.addCookie(phoneCookie);
		response.addCookie(emailCookie);
		response.addCookie(passwordCookie);

		User user = new User();
		user.setEmail("email");
		user.setFirstname("firstName");
		user.setLastname("lastName");
		user.setPassword("password");
		user.setPhone("phone");
		user.setUsername("username");
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
