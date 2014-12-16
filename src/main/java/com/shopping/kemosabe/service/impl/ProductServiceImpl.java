package com.shopping.kemosabe.service.impl;



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

		
	
}
