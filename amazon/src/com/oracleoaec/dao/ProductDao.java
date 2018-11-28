package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Product;

public interface ProductDao {
	
	
	
	
	/**
	 * 查询指定行范围的商品
	 * @return 分页商品
	 */
	List<Product> findProducts(int stsrtNum,int endNum);
	
	
	/**
	 * 查询商品总数
	 * @return 商品总数
	 */
	int findProducts();
	
	
	Product findProductById(Long hpId);
	
	/**
	 * 根据某一父级目录查询产品
	 * 查询指定行范围的商品
	 * @param categoryId
	 * @return List<Product>
	 */
	List<Product> productByParentCategory(int parentId,int stsrtNum,int endNum);
	
	/**
	 * 
	 * 指定父级目录产品数量
	 * @param parentId
	 * @return
	 */
	int productByParentCategory(int parentId);
	
	/**
	 * 根据某一子级目录查询产品
	 * 查询指定行范围的商品
	 * @param categoryId
	 * @return List<Product>
	 */
	List<Product> productByChildCategory(int childId,int stsrtNum,int endNum);
	
	/**
	 * 指定子级目录商品数量
	 * @param childId
	 * @return
	 */
	int productByChildCategory(int childId);
	
	/**
	 * 更新指定产品库存
	 * @param hpStock
	 * @return
	 */
	int changeStock(Long hpStock,Long hpId);
	
	/**
	 * 根据商品名模糊查询产品
	 * @param qname
	 * @return List<Product>
	 */
	
	List<Product> queryProducts(String qname,int stsrtNum,int endNum);
	
	/**
	 * 根据商品名模糊查询产品数量
	 * @param qname
	 * @return
	 */
	int countQueryProducts(String qname);
	
	
	
}
