package com.shopping.kemosabe.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.domain.Transaction;
import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.exceptions.ImageFileNullException;
import com.shopping.kemosabe.exceptions.ImageUploadFailedException;
import com.shopping.kemosabe.service.CategoryService;
import com.shopping.kemosabe.service.ProductService;
import com.shopping.kemosabe.service.TransactionService;

@Controller
@RequestMapping("/user/products")
@SessionAttributes({ "isLoggedIn", "loggedUser" })
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddProductForm(
			@ModelAttribute("newProduct") Product newProduct, Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddProductForm(Model model,
			@ModelAttribute("newProduct") @Valid Product newProduct,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", categoryService.getAllCategories());
			return "addProduct";
		}

		newProduct.setProductAvailability(1);
		newProduct.setProductUploadedDate(new java.sql.Date((new Date())
				.getTime()));
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
		
		UserRegistration u= ((UserRegistration)((ModelMap) model).get("loggedUser"));
		newProduct.setUserId(u.getUserid());
		newProduct.setProductImage(newProduct.getProductName() + ".jpg");
		productService.addProduct(newProduct);
		return "home";

	}

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buyProductForm(@RequestParam("productId") String productId,
		Model model, HttpServletRequest request) {
		System.out.println(productId);
		long id = Long.parseLong(productId);
		Product p = productService.getProductById(id);
		UserRegistration buyer = ((UserRegistration) ((ModelMap) model).get("loggedUser")); 
		
		if (buyer != null) {
			long buyerId = buyer.getUserid();
			Transaction transaction = new Transaction();
			transaction.setProductId(id);
			transaction.setSellerId(p.getUserId());
			transaction.setBuyerId(buyerId);
			transaction.setBoughtDate(new java.sql.Date((new Date()).getTime()));
			transaction.setBoughtPrice(p.getProductPrice());
			transactionService.addTransaction(transaction);
			productService.updateProductAvailability(id, 0);
			return "home";
		}
		return "welcome";
	}

	@ExceptionHandler(ImageUploadFailedException.class)
	public ModelAndView handleImageUploadFailedException(
			HttpServletRequest request, Exception ex) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", ex);
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.setViewName("error");
		return modelAndView;
	}

	@ExceptionHandler(ImageFileNullException.class)
	public ModelAndView handleImageFileNullException(
			HttpServletRequest request, Exception ex) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", ex);
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.setViewName("error");
		return modelAndView;
	}

	@RequestMapping("/allProducts")
	public ModelAndView allProducts() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.setViewName("products");

		return modelAndView;
	}

	@RequestMapping("/boughtProducts")
	public ModelAndView allUserBoughtProducts(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		UserRegistration buyer = ((UserRegistration) ((ModelMap) model).get("loggedUser")); 
		if (buyer != null) {
		long buyerId = buyer.getUserid();
		modelAndView.addObject("productsBought", transactionService.getTransactionsByBuyers(buyerId));
		modelAndView.setViewName("productsBought");
		}
		else
		{
			modelAndView.setViewName("home");
		}
		return modelAndView;
	}
	
	@RequestMapping("/myProducts")
	public ModelAndView getUserProducts(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		long userId = ((UserRegistration) ((ModelMap) model).get("loggedUser"))
				.getUserid();
		modelAndView.addObject("products",
				productService.getUserProducts(userId));
		modelAndView.setViewName("products");
		return modelAndView;
	}

}
