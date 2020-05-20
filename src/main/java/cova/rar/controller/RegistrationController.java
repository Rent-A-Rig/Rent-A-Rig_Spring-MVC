package cova.rar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cova.rar.entities.User;
import cova.rar.service.UserService;
import cova.rar.validator.UserValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	
	// click on register button
	@PostMapping("/registerProcess")
	public String registerProcess(@ModelAttribute("user") @Validated User user, 
		      BindingResult bindingResult, Model model) {
		
	      if (bindingResult.hasErrors()) {
	    	 System.out.println("Validation has error!");
	    	 System.out.println(bindingResult.getFieldErrorCount());
	    	 
	    	 List<ObjectError> errors = bindingResult.getAllErrors();
	    	 for(ObjectError error:errors) {
	    		 System.out.println(error);
	    	 }
	    	 System.out.println();
	         return "register";
	      }

	      userService.register(user);
	      return "welcome";
	}
}


