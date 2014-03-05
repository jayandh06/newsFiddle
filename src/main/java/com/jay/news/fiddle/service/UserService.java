package com.jay.news.fiddle.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.news.fiddle.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public boolean isValidUser(String userid, String password){
		try 
		{
			userDao.findByUserIdPassword(userid, password);
			return true;
		}
		catch(NoResultException nre) {
			return false;
		}
		
	}
}
