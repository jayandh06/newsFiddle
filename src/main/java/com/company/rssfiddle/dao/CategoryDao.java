package com.company.rssfiddle.dao;

import com.company.rssfiddle.domain.Category;

public interface CategoryDao extends GenericDao<Category> {

	public Category getCategoryByName(String Name);
	 
}
