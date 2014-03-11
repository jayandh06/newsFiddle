package com.jay.news.fiddle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jay.news.fiddle.domain.User;
import com.jay.news.fiddle.service.UserService;

@Controller
@SessionAttributes("user")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/validate")
	@ResponseBody
	public boolean validateLogin(){
		
		return true;
	}
	
	@RequestMapping(value="")
	protected String index(){
 		return "index";
	}
	
	@RequestMapping("/showSignup")
	public String showSignup(){
		
		return "signup";
	}
	
	@RequestMapping("/signup")
	public String signup(@RequestParam String username, @RequestParam String password1){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password1);
		user.setActive(false);		
				
		userService.createUser(user);
		
		
		return "news";
	}
}
