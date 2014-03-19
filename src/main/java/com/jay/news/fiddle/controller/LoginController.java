package com.jay.news.fiddle.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jay.news.fiddle.domain.FBUser;
import com.jay.news.fiddle.domain.User;
import com.jay.news.fiddle.domain.UserProfile;
import com.jay.news.fiddle.service.UserProfileService;
import com.jay.news.fiddle.service.UserService;
import com.jay.news.fiddle.util.NewsFiddleConstants;

@Controller
@RequestMapping("/login")
@Transactional
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;

	@RequestMapping("/validate")
	public ModelAndView validateLogin(@RequestParam String username,
			@RequestParam String password, HttpSession session) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		ModelAndView model;
		user = userService.isValidUser(user);
		UserProfile profile = userProfileService.findProfileByUserId(user.getUserId());
		
		
		if (user != null) {
			activateUserSession(user,profile, session);
			model = new ModelAndView("news");
			return model;
		} else {
			model = new ModelAndView("index");
			model.addObject("message", "Invalid username/password. Try again");
			return model;
		}
	}

	@RequestMapping(value="/fblogin", method = RequestMethod.POST)
	@ResponseBody
	public String fblogin(@RequestBody FBUser fbUser, HttpSession session) {
		
		User user;
		UserProfile profile;
		
		try {
		    profile = userProfileService.findProfileByEmailId(fbUser.getEmail());
		    try{
		    	user = userService.findByFBId(fbUser.getId());
		    }
		    catch(NoResultException nre){
		    	//User with fbuser email found, but not linked to fb account
		    	user = userService.findUserById(profile.getUserId());
		    	user.setFbId(fbUser.getId());
		    	//userService.updateUser(user);
		    }
			
		} catch (NoResultException nre) {
			//fb user not found in DB create a new User
			user = new User();
			user.setFbId(fbUser.getId());
			user.setAdmin(false);
			//user.setUsername(fbUser.getUsername());
			userService.createUser(user);
			
			user = userService.findByFBId(fbUser.getId());
			
			profile = new UserProfile();
			profile.setEmailId(fbUser.getEmail());
			profile.setFirstName(fbUser.getFirstName());
			profile.setLastName(fbUser.getLastName());
			profile.setUser(user);
			
			if(fbUser.getGender().equalsIgnoreCase("MALE")){
				profile.setGender('M');
			}
			else{
				profile.setGender('F');
			}
			userProfileService.createProfile(profile);
			
			
		}

		session.setAttribute(NewsFiddleConstants.SESSION_USER_ID,user.getUserId());
		//session.setAttribute(NewsFiddleConstants.SESSION_USER_NAME,user.getUsername());
		String fullName = profile.getLastName()+", "+profile.getFirstName();
		session.setAttribute(NewsFiddleConstants.SESSION_USER_FULLNAME,
				fullName);
		
		return "{\"redirectPage\":\"/synd/news\"}";
	}

	@RequestMapping("/quit")
	public ModelAndView logout(HttpSession session) {
		invalidateUserSession(session);
		ModelAndView model = new ModelAndView("index");
		model.addObject("message", "Logout successful");
		return model;
	}

	private void invalidateUserSession(HttpSession session) {
		session.setAttribute(NewsFiddleConstants.SESSION_USER_ID, null);
		session.setAttribute(NewsFiddleConstants.SESSION_USER_FULLNAME, null);
		session.setAttribute(NewsFiddleConstants.SESSION_USER_ISADMIN, null);
		//session.setAttribute(NewsFiddleConstants.SESSION_USER_NAME, null);
	}

	@RequestMapping(value = "")
	protected String index() {
		return "index";
	}

	@RequestMapping("/showSignup")
	public String showSignup() {
		return "signup";
	}

	@RequestMapping("/signup")
	public String signup(@RequestParam String username,
			@RequestParam String password1, HttpSession session) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password1);
		user.setActive(false);
		user.setAdmin(false);

		userService.createUser(user);

		user = userService.isValidUser(user);
		if (user != null) {
			activateUserSession(user, null,session);
		}
		return "news";
	}
	
	private void activateUserSession(User user,UserProfile profile,HttpSession session){
		//session.setAttribute(NewsFiddleConstants.SESSION_USER_NAME,user.getUsername());
		String fullName = "";
		if(profile != null){
			fullName = profile.getLastName()+", "+profile.getFirstName();
		}
		
		session.setAttribute(NewsFiddleConstants.SESSION_USER_ID,user.getUserId());
		session.setAttribute(NewsFiddleConstants.SESSION_USER_FULLNAME, fullName);
		session.setAttribute(NewsFiddleConstants.SESSION_USER_ISADMIN,user.isAdmin());		
		
	}
}
