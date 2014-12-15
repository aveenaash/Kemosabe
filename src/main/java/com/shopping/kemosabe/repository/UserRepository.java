package com.shopping.kemosabe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shopping.kemosabe.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	@Query("SELECT u FROM user_info u where u.userid = :id")
	public User findByUserId(@Param("id") String key);
	
	@Query("SELECT u FROM user_info u where u.email = :email")
	public User findByEmail(@Param("email") String key);
}
