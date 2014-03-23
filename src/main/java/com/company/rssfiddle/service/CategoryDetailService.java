package com.company.rssfiddle.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.rssfiddle.dao.CategoryDetailDao;
import com.company.rssfiddle.domain.CategoryDetail;

@Service
public class CategoryDetailService {
	
	private static Logger log = Logger.getLogger(CategoryDetailService.class);
	
	@Autowired
	CategoryDetailDao categoryDetailDao;
	
	public void saveCategoryDetail(CategoryDetail catDetail){
		categoryDetailDao.save(catDetail);
	}
	
	public void updateCategoryDetail(CategoryDetail catDetail){
		categoryDetailDao.update(catDetail);
	}
	
	public void deleteCategoryDetail(int categoryDetailId){
		categoryDetailDao.delete(categoryDetailId);
	}
	
	public List<CategoryDetail> getAllCategoryDetails(){
		return categoryDetailDao.getAll();
	}
	public List<CategoryDetail> getDetailsByCategory(int categoryId){
		return categoryDetailDao.getDetailsByCategory(categoryId);
	}
	
	public CategoryDetail getDetailById(int id){
		return categoryDetailDao.get(id);
	}
}
