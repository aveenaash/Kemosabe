package com.shopping.kemosabe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes ({"isLoggedIn", "loggedUser"})

public class HomePageController {
	@RequestMapping (value="/user/home")
	public String userHomeHandler(Model model){
		return "home";
	}
}
