package com.shopping.kemosabe.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.domain.UserRegistration;

import org.springframework.web.servlet.ModelAndView;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.service.CategoryService;

import com.shopping.kemosabe.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes ({"isLoggedIn", "loggedUser"})
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		UserRegistration user = (UserRegistration) ((ModelMap)model).get("loggedUser");
		if (user != null) {	
			model.addAttribute("products", productService.searchByUser("a{{", user.getUserid()));
		} else {
			model.addAttribute("products", productService.search("a{{"));
		}
		model.addAttribute("categories", categoryService.getAllCategories());
		return "welcome";
	}
	
	@RequestMapping("/findProducts")
	public ModelAndView searchProductsBykeyWord(Model model,HttpServletRequest request) {
		String keyWord=request.getParameter("search");
		ModelAndView modelAndView = new ModelAndView();
			long userId = -1;
			
			try{
				userId = ((UserRegistration)((ModelMap) model).get("loggedUser")).getUserid();
			}catch(Exception e){
				
			}

			if(userId != -1){
				modelAndView.addObject("products", productService.searchByUser(keyWord, userId));
			}else{
				modelAndView.addObject("products", productService.search(keyWord));
			}
			modelAndView.setViewName("products");
		return modelAndView;
	}

}
