package com.shopping.kemosabe.domain;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductsBought {
	
	private String productName; 
	
	private String productDescription;
	
	private String productImage;
	 
	
	private User sellerUser; 
	
	private User buyerUser; 

	private double boughtPrice;
	
	private Date boughtDate;

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public User getSellerUser() {
		return sellerUser;
	}

	public void setSellerUser(User sellerUser) {
		this.sellerUser = sellerUser;
	}

	public User getBuyerUser() {
		return buyerUser;
	}

	public void setBuyerUser(User buyerUser) {
		this.buyerUser = buyerUser;
	}

	public double getBoughtPrice() {
		return boughtPrice;
	}

	public void setBoughtPrice(double boughtPrice) {
		this.boughtPrice = boughtPrice;
	}

	public Date getBoughtDate() {
		return boughtDate;
	}

	public void setBoughtDate(Date boughtDate) {
		this.boughtDate = boughtDate;
	}
	
	
		
	
}
