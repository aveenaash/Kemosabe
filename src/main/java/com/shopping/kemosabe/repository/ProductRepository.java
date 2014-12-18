package com.shopping.kemosabe.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.kemosabe.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	//need to return User who put the product for sell ?		
	public List<Product> getProductsByUserId(long userId);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE product set productAvailability = :availability WHERE productId = :productId")
	public void updateProductAvailability(@Param("availability") int availability,
										  @Param("productId") long productId );
	
	
	
}
