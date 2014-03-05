package com.jay.news.fiddle.dao;

import org.springframework.stereotype.Repository;

import com.jay.news.fiddle.domain.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements
		CategoryDao {

	
}
