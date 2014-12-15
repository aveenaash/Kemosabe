package com.shopping.kemosabe.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3238703924141722128L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "categoryId")
    private Long categoryId;
    
	@Size(max = 45)
    @Column(name = "categoryName")
    private String categoryName;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Product> productCollection;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Collection<Product> getProductCollection() {
		return productCollection;
	}

	public void setProductCollection(Collection<Product> productCollection) {
		this.productCollection = productCollection;
	}
}
