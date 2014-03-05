package com.jay.news.fiddle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController{

	@RequestMapping(value="/")
	protected String index(){
 		return "index";
	}
}
