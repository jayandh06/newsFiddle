package com.company.rssfiddle.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.rssfiddle.dao.UserProfileDao;
import com.company.rssfiddle.domain.UserProfile;

@Service
public class UserProfileService {

	@Autowired
	UserProfileDao userProfileDao;
	
	public UserProfile findProfileByUserId(int userId){
		try {
			return userProfileDao.findProfileByUserId(userId);
		}
		catch(NoResultException nre){
			return null;
		}
	}
	
	public void createProfile(UserProfile userProfile){
		userProfileDao.save(userProfile);
	}
	
	public void updateProfile(UserProfile userProfile){
		userProfileDao.update(userProfile);
	}
	
	public void deleteProfile(int userProfileId){
		userProfileDao.delete(userProfileId);
	}
	
	public UserProfile findProfileByEmailId(String emailId){
		return userProfileDao.findProfileByEmailId(emailId);
	}
}
