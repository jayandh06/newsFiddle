package com.jay.news.fiddle.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jay.news.fiddle.domain.CategoryDetail;


@Repository("categoryDetailDao")
public class CategoryDetailDaoImpl extends GenericDaoImpl<CategoryDetail> implements CategoryDetailDao{

	@Override
	public List<CategoryDetail> getDetailsByCategory(int categoryId) {
		
		Query query = em.createQuery("Select cd from CategoryDetail cd where categoryId = ?1");
		query.setParameter(1, categoryId);
		return (List<CategoryDetail>) query.getResultList();
	}

}
