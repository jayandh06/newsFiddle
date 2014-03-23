package com.company.rssfiddle.dao;

import java.util.List;

import com.company.rssfiddle.domain.Country;

public interface CountryDao extends GenericDao<Country> {
	public List<Country> getAllOrderByName();
}
