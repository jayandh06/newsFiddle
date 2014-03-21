package com.jay.news.fiddle.dao;

import java.util.List;

import com.jay.news.fiddle.domain.Country;

public interface CountryDao extends GenericDao<Country> {
	public List<Country> getAllOrderByName();
}
