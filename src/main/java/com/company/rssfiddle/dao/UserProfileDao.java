package com.company.rssfiddle.dao;

import com.company.rssfiddle.domain.UserProfile;

public interface UserProfileDao extends GenericDao<UserProfile>{
	public UserProfile findProfileByUserId(int userId);
	public  UserProfile findProfileByEmailId(String userId);
}
