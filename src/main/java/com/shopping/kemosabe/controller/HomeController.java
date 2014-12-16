package com.shopping.kemosabe.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.service.UserRegistrationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	@Autowired
//	AddressRepository addressRepository;
	
	@Autowired
	UserRegistrationService userRegService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		UserRegistration user = new UserRegistration();
		user.setPassword("passw0rd");
		user.setUserName("beannayak");
		//userRegService.save(user);
		
		System.out.println(userRegService.findByUserName(user.getUserName()).getPassword());
		return "welcome";
		
	}
	
}
