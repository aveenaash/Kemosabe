package com.shopping.kemosabe.repository;

import org.springframework.data.repository.CrudRepository;
import com.shopping.kemosabe.domain.User;

public interface UserInfoRepository extends CrudRepository<User, Long> {

	/*@Query ("SELECT u FROM user_info u WHERE userid = :userId")
	public User findUserInfoFromUserId(@Param("userId") String userId);*/

	public User findUserById(String userId);
}
