package com.oracleoaec.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.oracleoaec.entity.Comment;
import com.oracleoaec.serviceImpl.CommentServiceImpl;

public class CommentFilter implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//查找留言
		List<Comment> allComments = new CommentServiceImpl().allComments();
		req.setAttribute("allComments", allComments);
		chain.doFilter( req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
