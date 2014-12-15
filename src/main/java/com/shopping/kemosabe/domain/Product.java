package com.shopping.kemosabe.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "productId")
    private Long productId;
    
    @Size(max = 45)
    @Column(name = "productName")
    private String productName;
    
    @Size(max = 45)
    @Column(name = "productDescription")
    private String productDescription;
    
    @Column(name = "productPrice")
    private Double productPrice;
    
    @Size(max = 200)
    @Column(name = "productImage")
    private String productImage;
    
    @Column(name = "productAvailability")
    private Short productAvailability;
    
    @Column(name = "productUploadedDate")
    @Temporal(TemporalType.DATE)
    private Date productUploadedDate;
    
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    @ManyToOne(optional = false)
    private Category categoryId;
    
    @JoinColumn(name = "userId", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User userId;

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
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
