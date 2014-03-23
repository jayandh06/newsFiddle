package com.company.rssfiddle.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.company.rssfiddle.domain.UserProfile;

@Repository
public class UserProfileDaoImpl extends GenericDaoImpl<UserProfile> implements UserProfileDao{
	public UserProfile findProfileByUserId(int userId) {
		Query q = em.createQuery(" Select up from UserProfile up where up.userId = :userid");
		q.setParameter("userid", userId);
		
		return (UserProfile) q.getSingleResult();
	}

	@Override
	public UserProfile findProfileByEmailId(String emailId) {
		Query q = em.createQuery(" Select up from UserProfile up where up.emailId = :emailId");
		q.setParameter("emailId", emailId);
		
		return (UserProfile) q.getSingleResult();
	}
}
