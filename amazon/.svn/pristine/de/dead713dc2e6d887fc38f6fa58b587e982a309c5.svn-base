package com.oracleoaec.serviceImpl;

import java.util.List;

import com.oracleoaec.dao.ProductDao;
import com.oracleoaec.daoImpl.ProductDaoImpl;
import com.oracleoaec.entity.Product;
import com.oracleoaec.page.PageModel;
import com.oracleoaec.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao pdo=new ProductDaoImpl();
	
	@Override
	public Product findProductById(Long hpId) {
		return pdo.findProductById(hpId);
	}
	
	@Override
	public int changeStock(Long hpStock,Long hpId) {
		
		return pdo.changeStock(hpStock,hpId);
	}

	@Override
	public PageModel<Product> allProductModel(int pageNo, int pageSize) {
		
		List<Product> list = pdo.findProducts((pageNo-1)*pageSize+1, pageNo*pageSize);
		int totalNum = pdo.findProducts();
		PageModel<Product> pageModel = new PageModel<Product>(list, pageNo, pageSize, totalNum,"0",0,pageNo);
		return pageModel;
	}

	@Override
	public PageModel<Product> pageByParentCategory(int parentId, int pageNo, int pageSize) {
		List<Product> list = pdo.productByParentCategory(parentId, (pageNo-1)*pageSize+1, pageNo*pageSize);
		int totalNum = pdo.productByParentCategory(parentId);
		PageModel<Product> pageModel = new PageModel<Product>(list, pageNo, pageSize, totalNum,"1",parentId,pageNo);
		return pageModel;
	}

	@Override
	public PageModel<Product> pageByChildCategory(int childId, int pageNo, int pageSize) {
		List<Product> list = pdo.productByChildCategory(childId,(pageNo-1)*pageSize+1, pageNo*pageSize);
		int totalNum = pdo.productByChildCategory(childId);
		PageModel<Product> pageModel = new PageModel<Product>(list, pageNo, pageSize, totalNum,"2",childId,pageNo);
		return pageModel;
	}

	@Override
	public PageModel<Product> queryProducts(String qname, int pageNo, int pageSize) {
		List<Product> list = pdo.queryProducts(qname, (pageNo-1)*pageSize+1, pageNo*pageSize);
		int totalNum = pdo.countQueryProducts(qname);
		PageModel<Product> pageModel = new PageModel<Product>(list, pageNo, pageSize, totalNum,"3",qname,pageNo);
		return pageModel;
	}
	

}
