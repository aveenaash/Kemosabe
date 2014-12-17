package com.shopping.kemosabe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.shopping.kemosabe.validator.UserCredentials;


@Entity (name="userregistration")
@UserCredentials (username="username", password="password")
public class UserRegistration {
	
	@Id
	@Column(name="userid")
	private long userId;
	
	@Column (name="username")
	@NotEmpty (message="{kemosabe.login.invalidUserName}")
	private String userName;
	
	@Column (name="password")
	@NotEmpty (message="{kemosabe.login.invalidPassword}")	
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
