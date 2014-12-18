package com.shopping.kemosabe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.shopping.kemosabe.service.ProductService;

@Controller
@SessionAttributes ({"isLoggedIn", "loggedUser"})

public class HomePageController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping (value="/user/home")
	public String userHomeHandler(Model model){
		
		return "home";
	}
	
	@RequestMapping (value="/user/logout")
	public String userLogoutHandler(Model model, SessionStatus status){
		status.setComplete();
		return "redirect:/";
	}
}
