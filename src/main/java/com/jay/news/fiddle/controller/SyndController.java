package com.jay.news.fiddle.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jay.news.fiddle.service.CategoryService;
import com.jay.news.fiddle.service.ReaderService;
import com.sun.syndication.feed.synd.SyndEntry;

@Controller
@RequestMapping("/synd")
public class SyndController {

	private static final Logger log = Logger.getLogger(SyndController.class);
	@Autowired
	ReaderService readerService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/{categoryId}")
	public String getSyndByCategory(@PathVariable int categoryId){
		categoryService.getCategoriesByType(categoryId);
		return "result";
	}
	
	
	@RequestMapping("/news")
	public String showNews(){
		return "news";
	}
	
	@RequestMapping("/hotNews")
	@ResponseBody
	public String getHotNews(){
		URL url = null;
		try {
			url = new URL("http://feeds.reuters.com/reuters/businessNews");
		} catch (MalformedURLException e) {
			log.error("Invalid URL Exception");
		}
		List<SyndEntry> entries = readerService.getFeeds(url);
		Gson gson = new Gson();
		return gson.toJson(entries);
	}
}
