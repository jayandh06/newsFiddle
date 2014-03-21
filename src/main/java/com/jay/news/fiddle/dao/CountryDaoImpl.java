package com.jay.news.fiddle.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jay.news.fiddle.domain.Country;

@Repository
public class CountryDaoImpl extends GenericDaoImpl<Country> implements
		CountryDao {

	@Override
	public List<Country> getAllOrderByName() {
		Query q = em.createQuery("SELECT c FROM Country c order by c.countryName");
		return (List<Country>) q.getResultList();		
	}

	

}
