package com.company.rssfiddle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.rssfiddle.dao.CountryDao;
import com.company.rssfiddle.domain.Country;


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
