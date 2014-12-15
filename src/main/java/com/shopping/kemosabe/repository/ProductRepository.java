package com.shopping.kemosabe.repository;

import org.springframework.data.repository.CrudRepository;
import com.shopping.kemosabe.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	//need to return User who put the product for sell ?
	
}
