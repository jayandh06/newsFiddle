package com.jay.news.fiddle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.news.fiddle.dao.CountryDao;
import com.jay.news.fiddle.domain.Country;


@Service
public class CountryService {

	@Autowired
	private CountryDao countryDao;
	
	public List<Country> getAllCountries(){
		return countryDao.getAll();
	}
	
	public List<Country> getAllCountriesByName(){
		return countryDao.getAllOrderByName();
	}
}
