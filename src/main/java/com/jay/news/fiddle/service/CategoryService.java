package com.jay.news.fiddle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.news.fiddle.dao.CategoryDao;
import com.jay.news.fiddle.dao.CategoryDetailDao;
import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.domain.CategoryDetail;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CategoryDetailDao categoryDetailDao;
	
	public List<Category> getCategories(){
		return categoryDao.getAll();
	}
	
	public List<CategoryDetail> getCategoriesByType(int categoryId){
		return categoryDetailDao.getCategoryDetailsByCategory(categoryId);
	}
	
}
