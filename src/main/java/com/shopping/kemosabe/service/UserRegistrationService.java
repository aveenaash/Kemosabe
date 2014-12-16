package com.shopping.kemosabe.service;

import java.util.ArrayList;

import com.shopping.kemosabe.domain.UserRegistration;

public interface UserRegistrationService {
	public void save(UserRegistration user);
	public UserRegistration findByUserName (String UserName);
	public ArrayList<UserRegistration> findAll();
}
