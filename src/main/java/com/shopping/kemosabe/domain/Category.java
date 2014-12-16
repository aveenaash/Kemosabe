package com.shopping.kemosabe.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;


@Entity(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = 3238703924141722128L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "categoryId")
	private Long categoryId;
    
	@Size(max = 45)
    @Column(name = "categoryName")
    private String categoryName;
	 
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

}
