package com.jay.news.fiddle.dao;

import com.jay.news.fiddle.domain.UserProfile;

public interface UserProfileDao extends GenericDao<UserProfile>{
	public UserProfile findProfileByUserId(int userId);
	public  UserProfile findProfileByEmailId(String userId);
}
