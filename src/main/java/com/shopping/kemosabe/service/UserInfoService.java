package com.shopping.kemosabe.service;

import com.shopping.kemosabe.domain.User;

public interface UserInfoService {
	public void save(User entity);
	public User findUserById(String id);
}
