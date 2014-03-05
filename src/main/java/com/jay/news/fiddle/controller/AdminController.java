package com.jay.news.fiddle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("")
	public String showAdminMain() {
		return "admin";
	}
	
	@RequestMapping("/category")
	public String showCategoryPage() {
		return "category";		
	}
	
	@RequestMapping("/categoryDetail")
	public ModelAndView showCategoryDetailsPage() {
		
		List<Category> categories = categoryService.getCategories();
		Map<String,Integer> categoryMap = new HashMap<String,Integer>();
		for(Category category : categories){
			categoryMap.put(category.getCategoryName(),category.getCategoryId());
		}
		
		ModelAndView model = new ModelAndView("categoryDetail");
		model.addObject("categoryMap",categoryMap);
		return model;
	}

}
