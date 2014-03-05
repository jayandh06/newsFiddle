package com.jay.news.fiddle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jay.news.fiddle.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/validate")
	@ResponseBody
	public boolean validateLogin(){
		
		return true;
	}
	
	@RequestMapping("/signup")
	public ModelAndView newUserSignup(){
		ModelAndView model = new ModelAndView("signup");
		return model;
	}
}
