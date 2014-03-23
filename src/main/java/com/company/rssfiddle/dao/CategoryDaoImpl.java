package com.company.rssfiddle.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.company.rssfiddle.domain.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements
		CategoryDao {

	@Override
	public Category getCategoryByName(String categoryName) {
		Query q = getEntityManager().createQuery("Select c from Category c where c.categoryName= :categoryName");
		q.setParameter("categoryName", categoryName);
		return (Category) q.getSingleResult();
		
	}

	
	 
}
