package com.shopping.kemosabe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.kemosabe.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{
	
	//need to return User who put the product for sell ?
	
}
