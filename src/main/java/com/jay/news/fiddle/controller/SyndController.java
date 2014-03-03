package com.jay.news.fiddle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jay.news.fiddle.service.CategoryService;
import com.jay.news.fiddle.service.ReaderService;

@Controller
@RequestMapping("/synd")
public class SyndController {

	@Autowired
	ReaderService readerService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/{categoryId}")
	public String getSyndByCategory(@PathVariable int categoryId){
		categoryService.getCategoriesByType(categoryId);
		return "result";
	}
	
}
