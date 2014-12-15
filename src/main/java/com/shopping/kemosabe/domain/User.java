package com.shopping.kemosabe.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

@XmlRootElement 
@Entity(name = "user_info")
public class User implements Serializable {

	private static final long serialVersionUID = 4706897688434166420L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;
	
	@JoinColumn(name = "addressid", referencedColumnName = "addressid")
    @ManyToOne
    private Address addressid;
	
	@Column
	@Size (min=4, max=50, message="{user.error.visiblename}")
	private String visiblename;
	
	@Column
	@Email
	private String email;

	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public Address getAddressid() {
		return addressid;
	}
	public void setAddressid(Address addressid) {
		this.addressid = addressid;
	}
	public String getVisiblename() {
		return visiblename;
	}
	public void setVisiblename(String visiblename) {
		this.visiblename = visiblename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
