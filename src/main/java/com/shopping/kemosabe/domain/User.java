package com.shopping.kemosabe.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
@Entity(name = "user_info")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="userid")
	private BigInteger id;
	
	@Column
	private String addressLine1;
	
	@Column
	private String visiblename;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String zipcode;
	
	@Column
	private String country;
	
	@Column 
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getVisiblename() {
		return visiblename;
	}

	public void setVisiblename(String visiblename) {
		this.visiblename = visiblename;
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
