package com.jay.news.fiddle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.domain.CategoryDetail;
import com.jay.news.fiddle.service.CategoryDetailService;

@Controller
@RequestMapping("/categoryDetail")
public class CategoryDetailController {

	@Autowired
	CategoryDetailService categoryDetailService;
	
	@RequestMapping("/create")
	public ModelAndView createCategoryDetail(@RequestParam String companyName, @RequestParam String companyUrl, @RequestParam String categoryId, @RequestParam String rssUrl) {
		CategoryDetail catDetail = new CategoryDetail();
		
		Category category = new Category();
		
		category.setCategoryId(new Integer(categoryId));
		catDetail.setCategory(category);
		
		ModelAndView model = new ModelAndView("categoryDetail");
		model.addObject("message", "CategoryDetail Created successfully");
		return model;
		
	}
}
