package com.jay.news.fiddle.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public EntityManager getEntityManager() {
		return em;
	}

	@Transactional
	public void save(T t) {
		getEntityManager().persist(t);

	}

	@Transactional
	public void delete(T t) {
		getEntityManager().remove(t);
	}

	@Transactional
	public List<T> getAll() {
		final StringBuffer queryString = new StringBuffer("SELECT * from ");

		queryString.append(type.getSimpleName()).append(" o ");

		final Query query = this.em.createQuery(queryString.toString());

		return query.getResultList();
	}

	@Transactional
	public T get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
