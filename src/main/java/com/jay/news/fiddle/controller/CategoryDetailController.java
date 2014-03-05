package com.jay.news.fiddle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.domain.CategoryDetail;
import com.jay.news.fiddle.service.CategoryDetailService;
import com.jay.news.fiddle.service.CategoryService;

@Controller
@RequestMapping("/categoryDetail")
public class CategoryDetailController {

	@Autowired
	CategoryDetailService categoryDetailService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/create")
	public ModelAndView createCategoryDetail(@RequestParam String companyName, @RequestParam String companyUrl, @RequestParam String categoryId, @RequestParam String rssUrl) {
		CategoryDetail catDetail = new CategoryDetail();
		
		Category category = new Category();
		category.setCategoryId(new Integer(categoryId));
		
		catDetail.setCategory(category);
		catDetail.setCompany(companyName);
		catDetail.setCompanyUrl(companyUrl);
		catDetail.setRssUrl(rssUrl);
		
		categoryDetailService.saveCategoryDetail(catDetail);
		
		List<Category> categories = categoryService.getCategories();
		Map<String,Integer> categoryMap = new HashMap<String,Integer>();
		for(Category cat : categories){
			categoryMap.put(cat.getCategoryName(),cat.getCategoryId());
		}
		
		ModelAndView model = new ModelAndView("categoryDetail");
		model.addObject("categoryMap",categoryMap);
		model.addObject("message", "CategoryDetail Created successfully");
		return model;
		
	}
}
