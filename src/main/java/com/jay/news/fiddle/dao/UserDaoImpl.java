package com.jay.news.fiddle.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jay.news.fiddle.domain.User;

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
}
	
