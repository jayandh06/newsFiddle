package com.jay.news.fiddle.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	public GenericDaoImpl() {

		type = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

	}

	public EntityManager getEntityManager() {
		return em;
	}

	
	public void save(T t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	public void delete(T t) {
		em.remove(t);
	}

	public List<T> getAll() {
		final StringBuffer queryString = new StringBuffer("SELECT o from ");
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
