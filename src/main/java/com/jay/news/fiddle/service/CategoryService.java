package com.jay.news.fiddle.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.news.fiddle.dao.CategoryDao;
import com.jay.news.fiddle.domain.Category;

@Service
public class CategoryService {

	private static Logger log = Logger.getLogger(CategoryService.class);

	@Autowired
	private CategoryDao categoryDao;
	
	public void saveCategory(Category cat) {
		categoryDao.save(cat);
	}

	public List<Category> getCategories() {
		return categoryDao.getAll();
	}
	
	public void modifyCategory(Category category){
		categoryDao.update(category);
	}
	
	public void deleteCategory(Category category){		
		categoryDao.delete(category);
	}

}
