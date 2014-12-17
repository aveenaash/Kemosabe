package com.shopping.kemosabe.service.impl;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.repository.ProductRepository;
import com.shopping.kemosabe.service.CategoryService;
import com.shopping.kemosabe.service.ProductService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryService categoryService;
	
	@Override
	public void addProduct(Product p) {
		productRepository.save(p);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> lstOfProducts = new ArrayList<Product>();
		lstOfProducts = (List<Product>) productRepository.findAll();
		
		return lstOfProducts;
	}

	@Override
	public List<Product> getUserProducts(long userId) {
		List<Product> lstOfProducts = new ArrayList<Product>();
		lstOfProducts = (List<Product>) productRepository.getProductsByUserId(userId);
		return lstOfProducts;
	}

	@Override	
	public ArrayList<Product> search(String Keyword) {
		String KeywordInLower = Keyword.toLowerCase();
		ArrayList<Product> productList = (ArrayList<Product>)productRepository.findAll();
		ArrayList<Product> returnProductList = new ArrayList<Product>();
		
		for (Product product :  productList) {
			if (product.getProductAvailability() == 1){
				if (product.getProductDescription().toLowerCase().contains(KeywordInLower) || 
						product.getProductDescription().toLowerCase().contains(KeywordInLower) ||
						KeywordInLower.equals("a{{")){
					returnProductList.add(product);
				} 
			}
		}
		return returnProductList;
	}
	
	@Override
	public Product getProductById(long productId) {
		return null;
	}
}
