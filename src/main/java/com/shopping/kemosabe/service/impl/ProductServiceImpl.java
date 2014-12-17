package com.shopping.kemosabe.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.repository.ProductRepository;
import com.shopping.kemosabe.service.ProductService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
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
	public Product getProductById(long productId) {
		return null;
	}

}
