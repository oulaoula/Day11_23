package com.oracleoaec.serviceImpl;



import java.util.List;

import com.oracleoaec.dao.CategoryDao;
import com.oracleoaec.daoImpl.CategoryDaoImpl;
import com.oracleoaec.entity.Category;
import com.oracleoaec.service.CategoryService;


public class CategoryServiceImpl implements CategoryService{
	CategoryDao icd=new CategoryDaoImpl();
	@Override
	public String[] categoryForProduct(Long hpcId, Long hpcChildId) {
		String[] strs=new String[2];
		strs[0]=icd.categoryNameById(hpcId);
		strs[1]=icd.categoryNameById(hpcChildId);
		return strs;
	}
	@Override
	public Object[][] getAllCategory() {
		List<Category> list = icd.parentCategory();
		Object[][] obj=new Object[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			obj[i][0]=list.get(i);
			obj[i][1]=icd.childCategory(list.get(i).getHpcId());
		}
		return obj;
	}

	

}
