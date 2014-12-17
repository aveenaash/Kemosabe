package com.shopping.kemosabe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.kemosabe.domain.User;
import com.shopping.kemosabe.repository.UserInfoRepository;
import com.shopping.kemosabe.service.UserInfoService;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Override
	public void save(User entity) {
		userInfoRepository.save(entity);
	}

	@Override
	public User findUserById(String id) {
		return userInfoRepository.findUserById(id);
	}

}
