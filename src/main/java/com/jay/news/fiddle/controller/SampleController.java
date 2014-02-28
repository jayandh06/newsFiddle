package com.jay.news.fiddle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jay.news.fiddle.domain.Car;
import com.jay.news.fiddle.service.CarService;

@Controller
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	CarService carService;
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String getName(@PathVariable String name){
		return "Hello " + name;
	}
	
	@RequestMapping(value="/cars",method=RequestMethod.GET)
	@ResponseBody
	public String getName(){
		List<Car> cars = carService.getCars();
		return cars.get(0).getCompany();
	}
	
}
