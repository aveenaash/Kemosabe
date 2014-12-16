package com.shopping.kemosabe.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.service.CategoryService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddProductForm(@ModelAttribute("newProduct") Product newProduct, Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "addProduct";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddProductForm(@ModelAttribute("newProduct") Product newProduct, Model model) {
		return "addProduct";
	}
	
	
	@RequestMapping(value = "/forsale", method = RequestMethod.GET)
	public String showProducts(Model model) {
		return "products";
	}
}