package com.jay.news.fiddle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@RequestMapping("/manage")
	public ModelAndView showCategoryPage(){
		ModelAndView model = new ModelAndView("criteria");
		return model;
	}
	@RequestMapping("/create")
	public String createCategory(){
		
		return "success";
	}
}
