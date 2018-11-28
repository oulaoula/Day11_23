package com.oracleoaec.service;

import java.util.List;

import com.oracleoaec.entity.Comment;

public interface CommentService {

	/**
	 * 客户留言 插入数据
	 * @param comment
	 * @return
	 */
	int addComment(Comment comment);
	
	

	
	/**
	 * 查看所有留言
	 * @return
	 */
	List<Comment> allComments();
	
	
	
	
}
