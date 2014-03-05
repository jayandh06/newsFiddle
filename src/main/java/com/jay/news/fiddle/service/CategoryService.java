package com.jay.news.fiddle.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jay.news.fiddle.dao.CategoryDao;
import com.jay.news.fiddle.dao.CategoryDetailDao;
import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.domain.CategoryDetail;

@Service
@Transactional
public class CategoryService {

	private static Logger log = Logger.getLogger(CategoryService.class);

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private CategoryDetailDao categoryDetailDao;

	public void saveCategory(Category cat) {
		categoryDao.save(cat);
	}

	public List<Category> getCategories() {
		return categoryDao.getAll();
	}

	public List<CategoryDetail> getCategoriesByType(int categoryId) {
		return categoryDetailDao.getCategoryDetailsByCategory(categoryId);
	}

}
