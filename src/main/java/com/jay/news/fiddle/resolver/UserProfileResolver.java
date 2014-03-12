package com.jay.news.fiddle.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jay.news.fiddle.domain.User;
import com.jay.news.fiddle.domain.UserProfile;
import com.jay.news.fiddle.util.NewsFiddleConstants;

public class UserProfileResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().equals(UserProfile.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
		if (parameter.getParameterType().equals(UserProfile.class)) {
			UserProfile userProfile = new UserProfile();	
			userProfile.setFirstName(webRequest.getParameter("firstName"));
			userProfile.setMiddleName(webRequest.getParameter("middleName"));
			userProfile.setLastName(webRequest.getParameter("lastName"));
			userProfile.setEmailId(webRequest.getParameter("primaryEmail"));
			userProfile.setZipCode(webRequest.getParameter("zipCode"));
			
			User user = new User();
			user.setUserId((Integer)webRequest.getAttribute(NewsFiddleConstants.SESSION_USER_ID,RequestAttributes.SCOPE_SESSION));
			
			userProfile.setUser(user);
			return userProfile;
		} else {
			return null;
		}

	}

}
