package com.jay.news.fiddle.controller;

import javax.persistence.EntityExistsException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	private static Logger log = Logger.getLogger(CategoryController.class);
	
	@Autowired
	CategoryService categoryService;

	
	@RequestMapping("/create")
	public ModelAndView createCategory(@RequestParam String categoryName) {
		Category cat = new Category();
		cat.setCategoryName(categoryName);
		try {
			categoryService.saveCategory(cat);
		} catch (Exception ee) {
			String message = "exception adding category";
			if(ee.getClass().equals(EntityExistsException.class)) {
				message = "Category Already exist";
			}
			log.error(message);
			
		}
		ModelAndView model = new ModelAndView("category");
		model.addObject("message", "Category Created successfully");
		return model;
	}
}
