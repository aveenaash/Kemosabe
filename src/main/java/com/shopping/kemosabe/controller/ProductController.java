package com.shopping.kemosabe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.service.CategoryService;
import com.shopping.kemosabe.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
		
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddProductForm(@ModelAttribute("newProduct") Product newProduct, Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "addProduct";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddProductForm(@ModelAttribute("newProduct")@Valid Product newProduct, Model model,
						BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			return "addProduct";
		}
		else
		{
			
			productService.addProduct(newProduct);
			return "addProduct";
		}
		
	}
	
	
	@RequestMapping(value = "/forsale", method = RequestMethod.GET)
	public String showProducts(Model model) {
		return "products";
	}
}
