package com.shopping.kemosabe.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "productId")
    private Long productId;
    
    @Size(max = 45)
    @Column(name = "productName")
    private String productName;
    
    @Size(max = 45)
    @Column(name = "productDescription")
    private String productDescription;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    
    
}
