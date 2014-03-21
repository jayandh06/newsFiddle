package com.jay.news.fiddle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jay.news.fiddle.domain.Country;
import com.jay.news.fiddle.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public String getAllCountries() {
		List<Country> countries = countryService.getAllCountriesByName();
		Gson gson = new Gson();
		return gson.toJson(countries);
	}
}
