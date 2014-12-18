package com.shopping.kemosabe.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes ({"isLoggedIn", "loggedUser"})
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		UserRegistration user = (UserRegistration) ((ModelMap)model).get("loggedUser");
		if (user != null) {	
			model.addAttribute("products", productService.searchByUser("a{{", user.getUserid()));
		} else {
			model.addAttribute("products", productService.search("a{{"));
		}
		return "welcome";
	}
	
}
