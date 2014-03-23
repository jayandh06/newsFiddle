package com.company.rssfiddle.dao;

import java.util.List;

import com.company.rssfiddle.domain.CategoryDetail;

public interface CategoryDetailDao extends GenericDao<CategoryDetail>{
	public List<CategoryDetail> getDetailsByCategory(int categoryId);
}
