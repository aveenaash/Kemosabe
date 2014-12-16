package com.shopping.kemosabe.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.kemosabe.domain.Category;
import com.shopping.kemosabe.repository.CategoryRepository;
import com.shopping.kemosabe.service.CategoryService;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) categoryRepository.findAll();
	}


}
