package com.shopping.kemosabe.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import com.shopping.kemosabe.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	//need to return User who put the product for sell ?
	
}
