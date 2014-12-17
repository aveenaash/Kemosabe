package com.shopping.kemosabe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shopping.kemosabe.service.ProductService;

@Controller
@SessionAttributes ({"isLoggedIn", "loggedUser"})

public class HomePageController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping (value="/user/home")
	public String userHomeHandler(Model model){
		model.addAttribute("products", productService.search("a{{"));
		return "home";
	}
}
