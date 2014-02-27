package com.jay.news.fiddle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.news.fiddle.dao.CarDao;
import com.jay.news.fiddle.domain.Car;

@Service
public class CarService {

	@Autowired
	CarDao carDao;
	
	public List<Car> getCars(){
		return carDao.getCars();
	}
}
