package com.jay.news.fiddle.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.domain.CategoryDetail;
import com.jay.news.fiddle.service.CategoryDetailService;
import com.jay.news.fiddle.service.CategoryService;
import com.jay.news.fiddle.service.ReaderService;
import com.jay.news.fiddle.util.SyndEntrySerializer;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;

@Controller
@RequestMapping("/synd")
public class SyndController {

	private static final Logger log = Logger.getLogger(SyndController.class);
	@Autowired
	ReaderService readerService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	CategoryDetailService categoryDetailService;

	@RequestMapping("/{categoryId}")
	public String getSyndByCategory(@PathVariable int categoryId) {
		categoryDetailService.getDetailsByCategory(categoryId);
		return "result";
	}

	@RequestMapping("/news")
	public String showNews() {
		return "news";
	}

	@RequestMapping("/hotNews/{categoryId}")
	@ResponseBody
	public String getHotNews(@PathVariable String categoryId) {

		List<CategoryDetail> catDetails = new ArrayList<CategoryDetail>();
		List<SyndEntry> entries = new ArrayList<SyndEntry>();
		
		//If categoryId is not there get all categories 
		if (categoryId == null) {
			List<Category> categories = categoryService.getCategories();
			for (Category category : categories) {
				catDetails.addAll(categoryDetailService
						.getDetailsByCategory(category.getCategoryId()));
			}
		} else {
			catDetails = categoryDetailService
					.getDetailsByCategory(new Integer(categoryId));
		}
		
		URL url = null;
		for (CategoryDetail catDetail : catDetails) {

			try {
				url = new URL(catDetail.getRssUrl());
				entries.addAll(readerService.getFeeds(url));

			} catch (MalformedURLException e) {
				log.error("Invalid URL Exception");
			}
			 			
		}
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(SyndEntryImpl.class,
				new SyndEntrySerializer());
		gsonBuilder.setPrettyPrinting();
		final Gson gson = gsonBuilder.create();
		
		return gson.toJson(entries.toArray(new SyndEntryImpl[0])); 
	}
}
