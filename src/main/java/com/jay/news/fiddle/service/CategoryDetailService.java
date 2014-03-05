package com.jay.news.fiddle.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jay.news.fiddle.dao.CategoryDetailDao;
import com.jay.news.fiddle.domain.CategoryDetail;

@Service
@Transactional
public class CategoryDetailService {
	
	private static Logger log = Logger.getLogger(CategoryDetailService.class);
	
	@Autowired
	CategoryDetailDao categoryDetailDao;
	
	public void saveCategoryDetail(CategoryDetail catDetail){
		categoryDetailDao.save(catDetail);
	}
	
}
