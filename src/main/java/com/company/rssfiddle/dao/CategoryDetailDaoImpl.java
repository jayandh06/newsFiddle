package com.company.rssfiddle.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.company.rssfiddle.domain.CategoryDetail;


@Repository("categoryDetailDao")
public class CategoryDetailDaoImpl extends GenericDaoImpl<CategoryDetail> implements CategoryDetailDao{

	@Override
	public List<CategoryDetail> getDetailsByCategory(int categoryId) {
		
		Query query = em.createQuery("Select cd from CategoryDetail cd where categoryId = ?1");
		query.setParameter(1, categoryId);
		return (List<CategoryDetail>) query.getResultList();
	}

}
