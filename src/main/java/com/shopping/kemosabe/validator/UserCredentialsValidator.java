package com.shopping.kemosabe.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.service.UserRegistrationService;

public class UserCredentialsValidator implements ConstraintValidator<UserCredentials, UserRegistration> {

	String userName;
	String password;
	
	@Autowired
	UserRegistrationService userRegisterService;
	
	@Override
	public void initialize(UserCredentials arg0) {
		userName = arg0.username();
		password = arg0.password();
	}

	@Override
	public boolean isValid(UserRegistration arg0,
			ConstraintValidatorContext arg1) {
		if (userRegisterService.findByUserName(arg0.getUserName()) != null){
			if (userRegisterService.findByUserName(arg0.getUserName()).getPassword().equals(arg0.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
