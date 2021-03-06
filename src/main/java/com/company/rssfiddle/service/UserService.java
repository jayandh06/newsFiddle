package com.company.rssfiddle.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.rssfiddle.dao.UserDao;
import com.company.rssfiddle.domain.User;

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
	
	public User findUserById(int userId){
		return userDao.get(userId);
	}
	
	public User findByFBId(String fbId){
		return userDao.findByFBId(fbId);
	}
	
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}
	
	public User isValidUser(User user){
		try 
		{
			return userDao.findByUserIdPassword(user.getUsername(), user.getPassword());
			
		}
		catch(NoResultException nre) {
			return null;
		}
		
	}
}
