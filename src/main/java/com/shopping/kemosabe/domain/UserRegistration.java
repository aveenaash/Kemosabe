package com.shopping.kemosabe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.shopping.kemosabe.validator.UserCredentials;


@Entity (name="userregistration")
public class UserRegistration {
	
	@Id
	@Column (name="userid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;

	
	@Column (name="username")
	@NotEmpty (message="{kemosabe.login.invalidUserName}")
	private String userName;
	
	@Column (name="password")
	@NotEmpty (message="{kemosabe.login.invalidPassword}")	
	private String password;
	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

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
