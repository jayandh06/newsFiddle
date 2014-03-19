package com.jay.news.fiddle.dao;

import com.jay.news.fiddle.domain.User;

public interface UserDao extends GenericDao<User> {

	public User findByUserIdPassword(String userid, String password);
	
	public User findByFBId(String fbId);
}
