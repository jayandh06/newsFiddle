package com.company.rssfiddle.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
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

import com.company.rssfiddle.domain.FBUser;
import com.company.rssfiddle.domain.User;
import com.company.rssfiddle.domain.UserProfile;
import com.company.rssfiddle.service.UserProfileService;
import com.company.rssfiddle.service.UserService;
import com.company.rssfiddle.util.RSSFiddleConstants;

@Controller
@RequestMapping("/login")
@Transactional
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	UserProfileService userProfileService;
		

	@RequestMapping("/validate")
	@ResponseBody
	public String validateLogin(@RequestParam String loginUsername,
			@RequestParam String password, HttpSession session) {

		User user = new User();
		user.setUsername(loginUsername);
		user.setPassword(password);
		//ModelAndView model;
		user = userService.isValidUser(user);

		if (user != null) {
			UserProfile profile = userProfileService.findProfileByUserId(user
					.getUserId());
			activateUserSession(user, profile, session);
			//model = new ModelAndView("feeds");
			return "{\"valid\" : true }";
		} else {
			//model = new ModelAndView("index");
			//model.addObject("message", "Invalid username/password. Try again");
			return "{\"valid\" : false, \"message\":\"Invalid username/password. Try again\"}";
		}
	}

	@RequestMapping(value = "/fblogin", method = RequestMethod.POST)
	@ResponseBody
	public String fblogin(@RequestBody FBUser fbUser, HttpSession session) {

		User user;
		UserProfile profile;

		try {
			profile = userProfileService
					.findProfileByEmailId(fbUser.getEmail());
			try {
				user = userService.findByFBId(fbUser.getId());
			} catch (NoResultException nre) {
				// User with fbuser email found, but not linked to fb account
				user = userService.findUserById(profile.getUserId());
				user.setFbId(fbUser.getId());
				// userService.updateUser(user);
			}

		} catch (NoResultException nre) {
			// fb user not found in DB create a new User
			user = new User();
			user.setFbId(fbUser.getId());
			user.setAdmin(false);
			// user.setUsername(fbUser.getUsername());
			userService.createUser(user);

			user = userService.findByFBId(fbUser.getId());

			profile = new UserProfile();
			profile.setEmailId(fbUser.getEmail());
			profile.setFirstName(fbUser.getFirstName());
			profile.setLastName(fbUser.getLastName());
			profile.setUser(user);

			if (fbUser.getGender().equalsIgnoreCase("MALE")) {
				profile.setGender('M');
			} else {
				profile.setGender('F');
			}
			userProfileService.createProfile(profile);

		}

		session.setAttribute(RSSFiddleConstants.SESSION_USER_ID,
				user.getUserId());
		// session.setAttribute(NewsFiddleConstants.SESSION_USER_NAME,user.getUsername());
		String fullName = profile.getLastName() + ", " + profile.getFirstName();
		session.setAttribute(RSSFiddleConstants.SESSION_USER_FULLNAME,
				fullName);

		return "{\"redirectPage\":\"/synd/feeds\"}";
	}

	@RequestMapping("/signout")
	@ResponseBody
	public String signout(HttpSession session) {
		invalidateUserSession(session);
		return "{\"valid\" : true}";
	}
	
	@RequestMapping(value="/appId",method=RequestMethod.GET)
	@ResponseBody
	public String fbAppId(HttpServletRequest request){
		if(request.getServerName().equalsIgnoreCase("LOCALHOST")){
			return "{\"appId\":\"705901259456455\"}";
		}
		else{
			return "{\"appId\":\"217755498419547\"}";
		}
		
		
	}

	private void invalidateUserSession(HttpSession session) {
		session.setAttribute(RSSFiddleConstants.SESSION_USER_ID, null);
		session.setAttribute(RSSFiddleConstants.SESSION_USER_NAME, null);
		session.setAttribute(RSSFiddleConstants.SESSION_USER_FULLNAME, null);
		session.setAttribute(RSSFiddleConstants.SESSION_USER_ISADMIN, null);
		// session.setAttribute(NewsFiddleConstants.SESSION_USER_NAME, null);
	}

	@RequestMapping(value = "")
	protected String index() {
		return "index";
	}

	@RequestMapping(value="/showSignup")
	public String showSignup() {
		return "signup";
	}

	@RequestMapping("/signup")
	@ResponseBody
	public String signup(@RequestParam String signupUsername,
			@RequestParam String password1, HttpSession session) {
		User user = new User();
		user.setUsername(signupUsername);
		user.setPassword(password1);
		user.setActive(false);
		user.setAdmin(false);

		userService.createUser(user);

		user = userService.isValidUser(user);
		if (user != null) {
			activateUserSession(user, null, session);
			return "{\"valid\" : true }";
		}
		else{
			return "{\"valid\" : false,\"message\":\"Signup Invalid\" }";
		}
		
	}

	private void activateUserSession(User user, UserProfile profile,
			HttpSession session) {
		// session.setAttribute(NewsFiddleConstants.SESSION_USER_NAME,user.getUsername());
		String fullName = "";
		if (profile != null) {
			fullName = profile.getLastName() + ", " + profile.getFirstName();
		}

		session.setAttribute(RSSFiddleConstants.SESSION_USER_ID,
				user.getUserId());
		if(user.getUsername() != null) {
			session.setAttribute(RSSFiddleConstants.SESSION_USER_NAME,user.getUsername());
		}
		else {
			session.setAttribute(RSSFiddleConstants.SESSION_USER_NAME, user.getFbId());
		}
		session.setAttribute(RSSFiddleConstants.SESSION_USER_FULLNAME,
				fullName);
		session.setAttribute(RSSFiddleConstants.SESSION_USER_ISADMIN,
				user.isAdmin());

	}
}
