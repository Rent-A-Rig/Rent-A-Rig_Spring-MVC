package cova.rar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
	
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public void showCart(HttpServletRequest request, HttpServletResponse response) {
		
		// check if logged in, else redirect to login page
		// 
	
		
		
	}
}
