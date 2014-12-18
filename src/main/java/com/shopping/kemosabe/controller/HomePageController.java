package com.shopping.kemosabe.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.service.ProductService;

@Controller
@SessionAttributes ({"isLoggedIn", "loggedUser"})

public class HomePageController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping (value="/user/home")
	public String userHomeHandler(Model model){
		
		UserRegistration user = (UserRegistration) ((ModelMap)model).get("loggedUser");
		if (user != null) {
			
			ArrayList<Product> products = productService.searchByUser("a{{", user.getUserid());
			model.addAttribute("products", products);
			
			for (Product p : products){
				System.out.println(p.toString());
			}
		}
		
		return "home";
	}
	
	@RequestMapping (value="/user/logout")
	public String userLogoutHandler(Model model, SessionStatus status){
		status.setComplete();
		return "redirect:/";
	}
}
