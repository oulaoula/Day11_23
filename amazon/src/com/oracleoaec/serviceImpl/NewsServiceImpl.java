package com.oracleoaec.serviceImpl;

import java.util.List;

import com.oracleoaec.dao.NewsDao;
import com.oracleoaec.daoImpl.NewsDaoImpl;
import com.oracleoaec.entity.News;
import com.oracleoaec.service.NewsService;

public class NewsServiceImpl implements NewsService{
	NewsDao ind=new NewsDaoImpl();
	@Override
	public List<News> getNews(int rownum) {
		return ind.getNews(rownum);
	}
	@Override
	public News getNewsById(Long hnId) {
		return ind.getNewsById(hnId);
	}

	
	
	
	
	
}
