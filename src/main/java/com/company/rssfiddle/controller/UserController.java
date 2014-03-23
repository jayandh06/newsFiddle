package com.company.rssfiddle.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.rssfiddle.domain.UserProfile;
import com.company.rssfiddle.service.CountryService;
import com.company.rssfiddle.service.UserProfileService;
import com.company.rssfiddle.service.UserService;
import com.company.rssfiddle.util.RSSFiddleConstants;
import com.company.rssfiddle.util.UserProfileSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RequestMapping("/user")
@Controller
@Transactional
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	CountryService countryService;

	@Autowired
	UserProfileService userProfileService;

	@RequestMapping("/createProfile")
	public ModelAndView createProfile(UserProfile userProfile) {
		userProfileService.createProfile(userProfile);
		ModelAndView model = new ModelAndView("profile");
		model.addObject("message", "Profile created successfully");
		return model;
	}

	@RequestMapping(value="/updateProfile",method=RequestMethod.PUT)
	public ModelAndView updateProfile(UserProfile userProfile) {
		userProfileService.updateProfile(userProfile);
		ModelAndView model = new ModelAndView("profile");
		model.addObject("message", "Profile updated successfully");
		return model;
	}

	@RequestMapping("/showProfile")
	public String showProfile() {
		return "profile";
	}

	@RequestMapping(value="/retrieveProfile",method=RequestMethod.GET)
	@ResponseBody
	public String retrieveProfile(HttpSession session) {

		Integer userId = (Integer) session
				.getAttribute(RSSFiddleConstants.SESSION_USER_ID);
		UserProfile profile;
		profile = userProfileService.findProfileByUserId(userId);
		if (profile != null) {
			profile.setUserId(userId);
			final GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(UserProfile.class,
					new UserProfileSerializer());
			gsonBuilder.setPrettyPrinting();
			final Gson gson = gsonBuilder.create();
			return gson.toJson(profile);

		} else {
			return "{}";
		}

	}

	
}
