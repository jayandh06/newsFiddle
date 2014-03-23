package com.company.rssfiddle.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	
	protected EntityManager em;

	private Class<T> type;

	public GenericDaoImpl() {

		type = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

	}

	public EntityManager getEntityManager() {
		return em;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(T t) {		
		getEntityManager().persist(t);
		
	}
	
	public void update(T t){
		getEntityManager().merge(t);
	}
	
	public void delete(int id) {
		T t = getEntityManager().find(type,id);
		getEntityManager().remove(t);
	}

	public List<T> getAll() {
		final StringBuffer queryString = new StringBuffer("SELECT o from ");
		queryString.append(type.getSimpleName()).append(" o ");
		final Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}


	public T get(int id) {
		return getEntityManager().find(type, id);		
		
	}

}
