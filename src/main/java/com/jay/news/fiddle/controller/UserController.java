package com.jay.news.fiddle.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.jay.news.fiddle.domain.User;
import com.jay.news.fiddle.domain.UserProfile;
import com.jay.news.fiddle.service.UserProfileService;
import com.jay.news.fiddle.service.UserService;
import com.jay.news.fiddle.util.NewsFiddleConstants;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@RequestMapping("/createProfile")
	public ModelAndView createProfile( UserProfile userProfile){
		userProfileService.createProfile(userProfile);
		ModelAndView model = new ModelAndView("profile");
		return model;
	}
	
	@RequestMapping("/showProfile")
	public String showProfile(){
		return "profile";
	}
	
	@RequestMapping("/retrieveProfile")
	@ResponseBody
	public String retrieveProfile(HttpSession session){
		
		Integer userid = (Integer)session.getAttribute(NewsFiddleConstants.SESSION_USER_ID);
		UserProfile profile;
		if(userid != null){
			try {
				profile = userProfileService.getUserProfile(userid);
			}
			catch(NoResultException nre){
				//Logged in, but profile not created yet
				return "";
			}
			
			final Gson gson = new Gson();
			return gson.toJson(profile);
		}
		else {
			return "";
		}
		
	}
}
