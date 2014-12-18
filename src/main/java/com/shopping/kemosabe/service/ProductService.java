package com.shopping.kemosabe.service;

import java.util.List;
import java.util.ArrayList;

import com.shopping.kemosabe.domain.Product;

public interface ProductService {
	
	public void addProduct(Product p);
	public void updateProductAvailability(long p,int availability);
	public List<Product> getAllProducts();
	public List<Product> getUserProducts(long userId);
	public Product getProductById(long productId);
	
	public ArrayList<Product> search(String Keyword);
	public ArrayList<Product> searchByUser(String Keyword, long userId);
}
