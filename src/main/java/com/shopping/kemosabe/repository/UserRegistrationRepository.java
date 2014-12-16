package com.shopping.kemosabe.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shopping.kemosabe.domain.UserRegistration;

@Repository
public interface UserRegistrationRepository extends 
					CrudRepository<UserRegistration, Long> {

	@Query ("SELECT u FROM USERREGISTER u WHERE USERNAME = :userName")
	public UserRegistration findUserByUserName(@Param("userName") String userName);
}
