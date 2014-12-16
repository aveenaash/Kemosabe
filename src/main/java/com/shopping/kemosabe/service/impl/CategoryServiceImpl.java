package com.shopping.kemosabe.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.kemosabe.domain.Category;
import com.shopping.kemosabe.service.CategoryService;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

//	@Autowired
//	private CategoryRepository categoryRepository;
//	
	@Override
	public List<Category> getAllCategories() {
		List<Category> categoryList=new ArrayList<Category>();
		return categoryList;
//		return (List<Category>) categoryRepository.findAll();
	}

}
