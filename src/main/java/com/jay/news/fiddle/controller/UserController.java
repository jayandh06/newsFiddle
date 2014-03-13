package com.jay.news.fiddle.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jay.news.fiddle.domain.Category;
import com.jay.news.fiddle.domain.User;
import com.jay.news.fiddle.domain.UserProfile;
import com.jay.news.fiddle.service.UserProfileService;
import com.jay.news.fiddle.service.UserService;
import com.jay.news.fiddle.util.CategorySerializer;
import com.jay.news.fiddle.util.NewsFiddleConstants;
import com.jay.news.fiddle.util.UserProfileSerializer;

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
		model.addObject("message","Profile created successfully");
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
			final GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(UserProfile.class,
					new UserProfileSerializer());
			gsonBuilder.setPrettyPrinting();
			final Gson gson = gsonBuilder.create();
			return gson.toJson(profile);
			
		}
		else {
			return "";
		}
		
	}
}
