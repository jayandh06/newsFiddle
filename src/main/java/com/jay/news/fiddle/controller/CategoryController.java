package com.jay.news.fiddle.controller;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.service.CategoryService;
import com.jay.news.fiddle.util.CategorySerializer;

@Controller
@RequestMapping("/category")
@Transactional
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
	
	@RequestMapping("/list")
	@ResponseBody
	public String getAllCategories(){
		List<Category> categories = categoryService.getCategories();
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Category.class, new CategorySerializer());
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();
		return gson.toJson(categories);
	}
}
