package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.News;

public interface NewsDao {
	
	/**
	 * 查询最新的rownum条消息
	 * @param rownum
	 * @return List<News>
	 */
	List<News> getNews(int rownum);
	
	/**
	 * 根据id查询新闻
	 * @param hnid
	 * @return News对象
	 */
	News getNewsById(Long hnId);
	
	
	
	
	
	
	
	
	
	
}
