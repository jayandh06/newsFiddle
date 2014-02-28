package com.jay.news.fiddle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/validate")
	@ResponseBody
	public boolean validateLogin(){
		return true;
	}
}
