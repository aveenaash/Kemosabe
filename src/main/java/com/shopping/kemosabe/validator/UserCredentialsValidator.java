package com.shopping.kemosabe.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopping.kemosabe.domain.SignUp;
import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.service.UserRegistrationService;

public class UserCredentialsValidator implements ConstraintValidator<UserCredentials, SignUp> {

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
	public boolean isValid(SignUp arg0,
			ConstraintValidatorContext arg1) {
		if (userRegisterService.findByUserName(arg0.getUsername()) != null){
			//if (userRegisterService.findByUserName(arg0.getUserName()).getPassword().equals(arg0.getPassword())) {
				return false;
			//}
		}
		return true;
	}

}
