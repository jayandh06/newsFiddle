package com.jay.news.fiddle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jay.news.fiddle.domain.Car;
 
 
public interface CarDao {
    public List<Car> getCars() throws DataAccessException;
    public Car getCar(Long carId) throws DataAccessException;
}