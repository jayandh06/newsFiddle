package com.jay.news.fiddle.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jay.news.fiddle.domain.User;
import com.jay.news.fiddle.service.UserService;
import com.jay.news.fiddle.util.NewsFiddleConstants;

@Controller
@SessionAttributes("user")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping("/validate")
	public ModelAndView validateLogin(@RequestParam String username,
			@RequestParam String password, HttpSession session) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		ModelAndView model;
		user = userService.isValidUser(user);
		if (user != null) {
			session.setAttribute(NewsFiddleConstants.SESSION_USER_ID,
					user.getUserId());
			session.setAttribute(NewsFiddleConstants.SESSION_USER_NAME,
					user.getUsername());
			model = new ModelAndView("news");
			return model;
		} else {
			model = new ModelAndView("index");
			model.addObject("message", "Invalid username/password. Try again");
			return model;
		}
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
		session.setAttribute(NewsFiddleConstants.SESSION_USER_NAME, null);
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

		userService.createUser(user);

		user = userService.isValidUser(user);
		if (user != null) {
			session.setAttribute(NewsFiddleConstants.SESSION_USER_ID,
					user.getUserId());
			session.setAttribute(NewsFiddleConstants.SESSION_USER_NAME,
					user.getUsername());
		}
		return "news";
	}
}
