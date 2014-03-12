package com.jay.news.fiddle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.news.fiddle.dao.UserProfileDao;
import com.jay.news.fiddle.domain.UserProfile;

@Service
public class UserProfileService {

	@Autowired
	UserProfileDao userProfileDao;
	
	public UserProfile getUserProfile(int userId){
		return userProfileDao.getUserProfileByUserId(userId);
	}
	
	public void createProfile(UserProfile userProfile){
		userProfileDao.save(userProfile);
	}
	
	public void update(UserProfile userProfile){
		userProfileDao.update(userProfile);
	}
	
	public void delete(int userProfileId){
		userProfileDao.delete(userProfileId);
	}
	
}
