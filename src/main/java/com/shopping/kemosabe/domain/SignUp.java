package com.shopping.kemosabe.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.kemosabe.validator.UserCredentials;

@UserCredentials (username="username", password="password", message="Username already taken")
public class SignUp {
	
	@NotEmpty (message="{app.signup.error.invalidusername}")
	private String username;
	
	@NotEmpty (message="{app.signup.error.invalidpassword}")
	private String password;
	
	@NotEmpty (message="{app.signup.error.invalidaddress}")
	private String addressLine1;
	
	@NotEmpty (message="{app.signup.error.invalidcity}")
	private String city;
	
	@NotEmpty (message="{app.signup.error.invalidstate}")
	private String state;
	
	@NotEmpty (message="{app.signup.error.invalidzipcode}")
	private String zipcode;
	
	@NotEmpty (message="{app.signup.error.invalidcountry}")
	private String country;
	
	@Email (message="{app.signup.error.invalidemail}")
	@NotEmpty (message="{app.signup.error.invalidemail}")
	private String email;
	
	@NotEmpty (message="{app.signup.error.invalidvisiblename}")
	private String visiblename;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	private MultipartFile file;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVisiblename() {
		return visiblename;
	}
	public void setVisiblename(String visiblename) {
		this.visiblename = visiblename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
