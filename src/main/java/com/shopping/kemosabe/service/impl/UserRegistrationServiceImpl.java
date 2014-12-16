package com.shopping.kemosabe.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.repository.UserRegistrationRepository;
import com.shopping.kemosabe.service.UserRegistrationService;

@Service
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	UserRegistrationRepository userRegistrationRepository;
	
	@Override
	public void save(UserRegistration user) {
		userRegistrationRepository.save(user);
	}

	@Override
	public UserRegistration findByUserName(String userName) {
		UserRegistration myUser = userRegistrationRepository.findUserByUserName(userName);
		return myUser;
	}

	@Override
	public ArrayList<UserRegistration> findAll() {
		return (ArrayList<UserRegistration>) userRegistrationRepository.findAll();
	}
}
