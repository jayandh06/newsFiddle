package com.jay.news.fiddle.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jay.news.fiddle.domain.UserProfile;

@Repository
public class UserProfileDaoImpl extends GenericDaoImpl<UserProfile> implements UserProfileDao{
	public UserProfile getUserProfileByUserId(int userId) {
		Query q = em.createQuery(" Select up from UserProfile up where up.userId = :userid");
		q.setParameter("userid", userId);
		
		return (UserProfile) q.getSingleResult();
	}
}
