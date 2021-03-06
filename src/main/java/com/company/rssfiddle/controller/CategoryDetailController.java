package com.company.rssfiddle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.rssfiddle.domain.Category;
import com.company.rssfiddle.domain.CategoryDetail;
import com.company.rssfiddle.service.CategoryDetailService;
import com.company.rssfiddle.service.CategoryService;
import com.company.rssfiddle.util.CategoryDetailSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/categoryDetail")
@Transactional
public class CategoryDetailController {

	private static Logger log = Logger
			.getLogger(CategoryDetailController.class);

	@Autowired
	CategoryDetailService categoryDetailService;
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/create")
	public ModelAndView createCategoryDetail(@RequestParam String providerName,
			@RequestParam String providerUrl, @RequestParam String categoryId,
			@RequestParam String rssUrl) {
		CategoryDetail catDetail = new CategoryDetail();

		Category category = new Category();
		category.setCategoryId(new Integer(categoryId));

		catDetail.setCategory(category);
		catDetail.setCompany(providerName);
		catDetail.setCompanyUrl(providerUrl);
		catDetail.setRssUrl(rssUrl);

		categoryDetailService.saveCategoryDetail(catDetail);

		ModelAndView model = new ModelAndView("categoryDetail");
		addCategoryListToModel(model);
		model.addObject("message", "CategoryDetail Created successfully");
		return model;

	}

	@RequestMapping("/list")
	@ResponseBody
	public String getAllCategoryDetails() {
		List<CategoryDetail> categoryDetails = categoryDetailService
				.getAllCategoryDetails();
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(CategoryDetail.class,
				new CategoryDetailSerializer());
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();
		return gson.toJson(categoryDetails);
	}
	
	@RequestMapping("/list/{categoryId}")
	@ResponseBody
	public String getCategoryDetailsForCategory(@PathVariable String categoryId) {
		List<CategoryDetail> categoryDetails = categoryDetailService.getDetailsByCategory(new Integer(categoryId));				
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(CategoryDetail.class,
				new CategoryDetailSerializer());
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();
		return gson.toJson(categoryDetails);
	}

	private void addCategoryListToModel(ModelAndView model) {
		List<Category> categories = categoryService.getCategories();
		Map<String, Integer> categoryMap = new HashMap<String, Integer>();
		for (Category cat : categories) {
			categoryMap.put(cat.getCategoryName(), cat.getCategoryId());
		}
		model.addObject("categoryMap", categoryMap);
	}

	@RequestMapping("/update")
	public ModelAndView modifyCategoryDetail(@RequestParam String providerName,
			@RequestParam String providerUrl,
			@RequestParam String categoryDetailId,
			@RequestParam String categoryId, @RequestParam String rssUrl) {
		CategoryDetail catDetail = new CategoryDetail();

		Category category = new Category();
		category.setCategoryId(new Integer(categoryId));

		catDetail.setCategory(category);
		catDetail.setCatDetailId(new Integer(categoryDetailId));
		catDetail.setCompany(providerName);
		catDetail.setCompanyUrl(providerUrl);
		catDetail.setRssUrl(rssUrl);

		categoryDetailService.updateCategoryDetail(catDetail);

		ModelAndView model = new ModelAndView("categoryDetail");
		addCategoryListToModel(model);
		model.addObject("message", "CategoryDetail updated successfully");
		return model;

	}

	@RequestMapping("/delete")
	public ModelAndView deleteCategory(@RequestParam String categoryDetailId) {

		try {
			categoryDetailService.deleteCategoryDetail(new Integer(
					categoryDetailId));
		} catch (Exception ee) {
			String message = "exception deleting CategoryDetail";
			log.error(message);

		}
		ModelAndView model = new ModelAndView("category");
		model.addObject("message", "CategoryDetail deleted successfully");
		return model;
	}

	@RequestMapping("/{id}")
	@ResponseBody
	public String getCategoryDetail(@PathVariable String id) {
		CategoryDetail categoryDetail = categoryDetailService
				.getDetailById(new Integer(id));

		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(CategoryDetail.class,
				new CategoryDetailSerializer());
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();
		return gson.toJson(categoryDetail);
	}
}
