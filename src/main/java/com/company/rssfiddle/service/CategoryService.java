package com.company.rssfiddle.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.rssfiddle.dao.CategoryDao;
import com.company.rssfiddle.domain.Category;

@Service
public class CategoryService {

	private static Logger log = Logger.getLogger(CategoryService.class);

	@Autowired
	private CategoryDao categoryDao;
	
	public void saveCategory(Category cat) {
		categoryDao.save(cat);
		log.info("Category Saved");
	}

	public List<Category> getCategories() {
		return categoryDao.getAll();
	}
	
	public void updateCategory(Category category){
		categoryDao.update(category);
	}
	
	public Category getCategoryByName(String categoryName){
		return categoryDao.getCategoryByName(categoryName);
	}
	public void deleteCategory(int catId){		
		categoryDao.delete(catId);
	}

	public Category getCategoryById(int id){
		return categoryDao.get(id);
	}
}
