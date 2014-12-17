package com.shopping.kemosabe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.shopping.kemosabe.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	//need to return User who put the product for sell ?
	
}
