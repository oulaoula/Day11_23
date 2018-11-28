package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Category;

public interface CategoryDao {
	
	/**
	 * 查询 所有的父级目录名字
	 * @return Category的List集合
	 */
	List<Category> parentCategory();
	
	/**
	 * 查询父级目录下的子目录名字
	 * @param hpcParentId
	 * @return Category的List集合
	 */
	List<Category> childCategory(int hpcParentId);
	
	
	/**
	 * 查询制定id的目录名称
	 * @param hpcId
	 * @return 目录名称
	 */
	String categoryNameById(Long hpcId);
	
	
}
