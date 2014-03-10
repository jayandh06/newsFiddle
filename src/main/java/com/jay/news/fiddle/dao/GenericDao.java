package com.jay.news.fiddle.dao;

import java.util.List;

public interface GenericDao<T> {

	public void save(T t);
	public void update(T t);
	public void delete(int id);
	public List<T> getAll();
	public T get(int id);
}
