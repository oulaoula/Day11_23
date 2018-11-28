package com.oracleoaec.service;

import java.util.List;

import com.oracleoaec.entity.News;

public interface NewsService {
	/**
	 * 查询最新的rownum条消息
	 * @param rownum
	 * @return List<News>
	 */
	List<News> getNews(int rownum);
	
	
	News getNewsById(Long hnId);
}
