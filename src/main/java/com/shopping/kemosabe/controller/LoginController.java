package com.shopping.kemosabe.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shopping.kemosabe.domain.UserRegistration;

@Controller
@SessionAttributes ("isLoggedIn")
public class LoginController {
	@RequestMapping (value="/login", method=RequestMethod.GET)
	public String loginHandler(@ModelAttribute("user") UserRegistration user, Model model){
		return "login";
	}
	
	@RequestMapping (value="/login", method=RequestMethod.POST)
	public String loginHandlerPost (@ModelAttribute("user") @Valid UserRegistration user, BindingResult result, Model model ) {
		if (result.hasErrors()){
			return "login";
		}
		model.addAttribute("isLoggedIn", "true");
		return "redirect:user/home";
	}
}
