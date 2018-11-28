package com.oracleoaec.serviceImpl;

import java.util.List;

import com.oracleoaec.dao.CommentDao;
import com.oracleoaec.daoImpl.CommentDaoImpl;
import com.oracleoaec.entity.Comment;
import com.oracleoaec.service.CommentService;

public class CommentServiceImpl implements CommentService{
	
	CommentDao icd= new CommentDaoImpl();
	@Override
	public int addComment(Comment comment) {
		
		return icd.addComment(comment);
	}

	@Override
	public List<Comment> allComments() {
		
		return icd.allComments();
	}

}
