package com.oracleoaec.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.oracleoaec.entity.News;
import com.oracleoaec.entity.Product;
import com.oracleoaec.page.PageModel;
import com.oracleoaec.serviceImpl.CategoryServiceImpl;
import com.oracleoaec.serviceImpl.NewsServiceImpl;
import com.oracleoaec.serviceImpl.OrderDetailServiceImpl;
import com.oracleoaec.serviceImpl.ProductServiceImpl;

public class ProductFilter implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//查找商品
		
		PageModel<Product> pageModel = new ProductServiceImpl().allProductModel(1, 12);
		List<News> news = new NewsServiceImpl().getNews(6);
		req.setAttribute("news", news);
		
		
		List<Product> hotProducts = new OrderDetailServiceImpl().hotProducts(8);
		Object[][] allCategory = new CategoryServiceImpl().getAllCategory();
		
		req.setAttribute("pageModel", pageModel);
		req.setAttribute("categoryInfo", allCategory);
		req.setAttribute("hotProducts", hotProducts);
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	
		
	}

	

}
