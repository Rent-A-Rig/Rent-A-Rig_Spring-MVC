package cova.rar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView productPage(HttpServletRequest request, HttpServletResponse response) {
		
		String filter = "all"; // default value for filter
		if (null != request.getAttribute("filter")) {
			filter = (String) request.getAttribute("filter");
		}
		
		if (filter.equals("all")) {
			Product[] products = productService.getProducts("all");
		}
		
		
		
		
		return null;
	}

}
