package com.company.rssfiddle.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.company.rssfiddle.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@Override
	public User findByUserIdPassword(String userid, String password) {
			Query q = em.createQuery("select u from User u where u.username = :username and u.password = :password");
			q.setParameter("username",userid);
			q.setParameter("password",password);
			return (User) q.getSingleResult();
	}

	@Override
	public User findByFBId(String fbId) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.fbId = :fbId");
		q.setParameter("fbId", fbId);				
		return (User) q.getSingleResult();
	}

	@Override
	public User findByUserName(String username) {
		Query q = em.createQuery("SELECT u from User u WHERE u.username = :username");
		q.setParameter("username", username);
		try {
			return (User) q.getSingleResult();	
		}
		catch(NoResultException nre){
			return null;
		}
		
	}
	
	
}
	
