package com.jay.news.fiddle.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.news.fiddle.dao.UserDao;
import com.jay.news.fiddle.domain.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public void createUser(User user){
		userDao.save(user);
	}
	
	public void deleteUser(User user){
		userDao.delete(user.getUserId());
	}
	
	public void updateUser(User user){
		userDao.update(user);
	}
	
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
