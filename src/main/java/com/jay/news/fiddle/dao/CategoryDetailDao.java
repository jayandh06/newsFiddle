package com.jay.news.fiddle.dao;

import java.util.List;

import com.jay.news.fiddle.domain.CategoryDetail;

public interface CategoryDetailDao extends GenericDao<CategoryDetail>{
	public List<CategoryDetail> getCategoryDetailsByCategory(int categoryId);
}
