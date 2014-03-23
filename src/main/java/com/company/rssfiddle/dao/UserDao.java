package com.company.rssfiddle.dao;

import com.company.rssfiddle.domain.User;

public interface UserDao extends GenericDao<User> {

	public User findByUserIdPassword(String userid, String password);
	
	public User findByFBId(String fbId);
}
