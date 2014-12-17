package com.shopping.kemosabe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	@RequestMapping (value="/user/home", method=RequestMethod.GET)
	public String userHomeHandler(Model model){
		System.out.println("");
		return "home";
	}
}
