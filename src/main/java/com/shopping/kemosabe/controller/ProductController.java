package com.shopping.kemosabe.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.exceptions.ImageFileNullException;
import com.shopping.kemosabe.exceptions.ImageUploadFailedException;
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
		System.out.println("sssssssssssssss");
		model.addAttribute("categories", categoryService.getAllCategories());
		return "addProduct";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddProductForm(Model model,@ModelAttribute("newProduct") @Valid Product newProduct, 
						BindingResult bindingResult) {		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("categories", categoryService.getAllCategories());
			return "addProduct";
		}
		
		newProduct.setProductAvailability(1);
		newProduct.setProductUploadedDate(new java.sql.Date((new Date()).getTime()));
		MultipartFile productImage = newProduct.getProductImg();
		
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File("/home/abinash/Desktop/tuesday/productImages/"+newProduct.getProductName()+".jpg"));
				
			} catch (Exception e) {
				throw new ImageUploadFailedException();
			}
		}
		else
		{
			throw new ImageFileNullException();
		}
		newProduct.setProductImage("/home/abinash/Desktop/tuesday/productImages/"+newProduct.getProductName()+".jpg");
		productService.addProduct(newProduct);		
		return "home";
		
		
	}
	
	
	@RequestMapping(value = "/forsale", method = RequestMethod.GET)
	public String showProducts(Model model) {
		return "products";
	}
	
	@ExceptionHandler(ImageUploadFailedException.class)
    public ModelAndView handleImageUploadFailedException(HttpServletRequest request, Exception ex){
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());         
        modelAndView.setViewName("error");
        return modelAndView;
    }
	
	@ExceptionHandler(ImageFileNullException.class)
    public ModelAndView handleImageFileNullException(HttpServletRequest request, Exception ex){
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());         
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
