package com.shopping.kemosabe.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shopping.kemosabe.domain.SignUp;
import com.shopping.kemosabe.domain.User;
import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.exceptions.ImageUploadFailedException;
import com.shopping.kemosabe.service.UserInfoService;
import com.shopping.kemosabe.service.UserRegistrationService;

@Controller
@SessionAttributes ({"isLoggedIn", "loggedUser"})

public class LoginController {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping (value="/login", method=RequestMethod.GET)
	public String loginHandler(@ModelAttribute("user") UserRegistration user, Model model){
		System.out.println("here");
		return "login";
	}
	
	@RequestMapping (value="/login/check/{username}", method=RequestMethod.GET)
	
	public @ResponseBody String read(@PathVariable("username") String username, HttpServletRequest req) {
		System.out.println("reached to read function: " + username);
		if (userRegistrationService.findByUserName(username) != null){
			return "message";
		} 
		return "available";
		
	}
	
	@RequestMapping (value="/login", method=RequestMethod.POST)
	public String loginHandlerPost (@ModelAttribute("user") @Valid UserRegistration user, BindingResult result, Model model, HttpServletRequest req ) {
		
		if (result.hasErrors()){
			return "login";
		}
		
		if (userRegistrationService.findByUserName(user.getUserName()) != null){
			if (userRegistrationService.findByUserName(user.getUserName()).getPassword().equals(user.getPassword())) {
//				req.getSession().setAttribute("isLoggedIn", "true");
				model.addAttribute("isLoggedIn","true");
				model.addAttribute("loggedUser",userRegistrationService.findByUserName(user.getUserName()));				
				return "redirect:user/home";
			}
		}
		model.addAttribute("invalidCredentials", "true");
		return "redirect:login";
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
		userInfo.setCountry(signup.getCountry());
		
		userRegistrationService.save(uR);
		userInfoService.save(userInfo);
		
		String rootDirectory = req.getSession().getServletContext().getRealPath("/");
		
		if (signup.getFile() != null){
			try {
				signup.getFile().transferTo(new File(rootDirectory + "\\resources\\Images\\" + signup.getUsername() + ".jpg"));
			} catch (Exception e){
				throw new ImageUploadFailedException();
			}
		}
		
		model.addAttribute("isLoggedIn", "true");
		model.addAttribute("loggedUser",userRegistrationService.findByUserName(uR.getUserName()));
		return "redirect:/user/home";
	}
}
