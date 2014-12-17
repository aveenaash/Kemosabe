package com.shopping.kemosabe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shopping.kemosabe.domain.SignUp;
import com.shopping.kemosabe.domain.User;
import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.service.UserInfoService;
import com.shopping.kemosabe.service.UserRegistrationService;

@Controller
@SessionAttributes ("isLoggedIn")
public class LoginController {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping (value="/login", method=RequestMethod.GET)
	public String loginHandler(@ModelAttribute("user") UserRegistration user, Model model){
		return "login";
	}
	
	@RequestMapping (value="/login", method=RequestMethod.POST)
	public String loginHandlerPost (@ModelAttribute("user") @Valid UserRegistration user, BindingResult result, Model model, HttpServletRequest req ) {
		if (result.hasErrors()){
			return "login";
		}
		
		req.getSession().setAttribute("isLoggedIn", "true");
		return "redirect:user/home";
	}
	
	@RequestMapping (value="/signup", method=RequestMethod.GET)
	public String signUpHandler(@ModelAttribute("signup") SignUp signup, Model model) {
		return "signup";
	}
	
	@RequestMapping (value="/signup", method=RequestMethod.POST)
	public String signupHandlerPost (@ModelAttribute("signup") @Valid SignUp signup, BindingResult result, Model model, HttpServletRequest req){

		System.out.println("blalalbalkjblkajlkajb");
		if (result.hasErrors()) {
			System.out.println("Error");
			return "signup";
		}
		
		UserRegistration uR = new UserRegistration();
		uR.setUserName(signup.getUsername());
		uR.setPassword(signup.getPassword());
		
		User userInfo = new User();
		userInfo.setVisiblename(signup.getVisiblename());
		userInfo.setAddressLine1(signup.getAddressLine1());
		userInfo.setCity(signup.getCity());
		userInfo.setState(signup.getState());
		userInfo.setZipcode(signup.getZipcode());
		userInfo.setEmail(signup.getEmail());
		
		userRegistrationService.save(uR);
		userInfoService.save(userInfo);
		
		return "welcome";
	}
}
