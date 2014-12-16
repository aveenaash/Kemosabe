package com.shopping.kemosabe.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.multipart.MultipartFile;

@XmlRootElement 
@Entity(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	
	@Column
	private long categoryId; 
	
	@Column
	private long userId; 
	
	@Column
	private String productName;
	
	@Column
	private String productDescription;
	
	@Column
	private double productPrice;
	
	@Column
	private String productImage;
	
	@Transient
	MultipartFile productImg;
	
	@Column
	private Short productAvailability;
	
	@Column
    private Date productUploadedDate;

	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

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

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public MultipartFile getProductImg() {
		return productImg;
	}

	public void setProductImg(MultipartFile productImg) {
		this.productImg = productImg;
	}

	public Short getProductAvailability() {
		return productAvailability;
	}

	public void setProductAvailability(Short productAvailability) {
		this.productAvailability = productAvailability;
	}

	public Date getProductUploadedDate() {
		return productUploadedDate;
	}

	public void setProductUploadedDate(Date productUploadedDate) {
		this.productUploadedDate = productUploadedDate;
	}
	
	
}
