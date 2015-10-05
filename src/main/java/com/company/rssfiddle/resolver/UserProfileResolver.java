package com.company.rssfiddle.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.company.rssfiddle.domain.User;
import com.company.rssfiddle.domain.UserProfile;
import com.company.rssfiddle.util.RSSFiddleConstants;

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
			userProfile.setCountryId(new Integer(webRequest.getParameter("countryId")));
			userProfile.setLastName(webRequest.getParameter("lastName"));
			userProfile.setEmailId(webRequest.getParameter("primaryEmail"));
			userProfile.setZipCode(webRequest.getParameter("zipCode"));
			userProfile.setGender(webRequest.getParameter("gender").charAt(0));
			
			User user = new User();
			user.setUserId((Integer)webRequest.getAttribute(RSSFiddleConstants.SESSION_USER_ID,RequestAttributes.SCOPE_SESSION));
			
			userProfile.setUser(user);
			return userProfile;
		} else {
			return null;
		}

	}

}
