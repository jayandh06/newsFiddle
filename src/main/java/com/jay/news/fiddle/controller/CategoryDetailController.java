package com.jay.news.fiddle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.domain.CategoryDetail;
import com.jay.news.fiddle.service.CategoryDetailService;
import com.jay.news.fiddle.service.CategoryService;
import com.jay.news.fiddle.util.CategoryDetailSerializer;
import com.jay.news.fiddle.util.CategorySerializer;

@Controller
@RequestMapping("/categoryDetail")
@Transactional
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
		
		ModelAndView model = new ModelAndView("categoryDetail");
		addCategoryListToModel(model);
		model.addObject("message", "CategoryDetail Created successfully");
		return model;
		
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String getAllCategoryDetails(){
		List<CategoryDetail> categoryDetails = categoryDetailService.getAllCategoryDetails();
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(CategoryDetail.class, new CategoryDetailSerializer());
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();
		return gson.toJson(categoryDetails);
	}
	
	private void addCategoryListToModel(ModelAndView model){
		List<Category> categories = categoryService.getCategories();
		Map<String,Integer> categoryMap = new HashMap<String,Integer>();
		for(Category cat : categories){
			categoryMap.put(cat.getCategoryName(),cat.getCategoryId());
		}		
		model.addObject("categoryMap",categoryMap);
	}
	
	@RequestMapping("/update")
	public ModelAndView modifyCategoryDetail(@RequestParam String companyName, @RequestParam String companyUrl,@RequestParam String catDetailId, @RequestParam String categoryId, @RequestParam String rssUrl) {
		CategoryDetail catDetail = new CategoryDetail();
		
		Category category = new Category();
		category.setCategoryId(new Integer(categoryId));
		
		catDetail.setCategory(category);
		catDetail.setCatDetailId(new Integer(catDetailId));
		catDetail.setCompany(companyName);
		catDetail.setCompanyUrl(companyUrl);
		catDetail.setRssUrl(rssUrl);
		
		categoryDetailService.updateCategoryDetail(catDetail);
		
		ModelAndView model = new ModelAndView("categoryDetail");
		addCategoryListToModel(model);
		model.addObject("message", "CategoryDetail updated successfully");
		return model;
		
	}
	
	@RequestMapping("/{id}")
	@ResponseBody
	public String getCategoryDetail(@PathVariable String id){
		CategoryDetail categoryDetail = categoryDetailService.getDetailById(new Integer(id));
		
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(CategoryDetail.class,
				new CategoryDetailSerializer());
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();		
		return gson.toJson(categoryDetail); 
	}
}
