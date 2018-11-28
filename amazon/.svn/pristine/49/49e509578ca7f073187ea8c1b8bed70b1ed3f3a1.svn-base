package com.oracleoaec.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.Util.JDBCTemplate;
import com.oracleoaec.Util.PreparedStatementSetter;
import com.oracleoaec.Util.RsCallBackHandler;
import com.oracleoaec.dao.CommentDao;
import com.oracleoaec.entity.Comment;

public class CommentDaoImpl extends JDBCTemplate implements CommentDao{
	private List<Comment> list=null;
	
	public int addComment(final Comment comment) {
		String sql="INSERT INTO HWUA_COMMENT(HC_ID,HC_CONTENT,HC_CREATE_TIME,HC_NICK_NAME) VALUES(SEQ_COMMENT.NEXTVAL,?,?,?)";
		int update = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, comment.getHcContent());
				pstmt.setDate(2, comment.getHcCreateTime());
				pstmt.setString(3, comment.getHcNickName());
			}
		});
		return update;
	}

	public List<Comment> allComments() {
		String sql="SELECT * FROM HWUA_COMMENT ORDER BY HC_ID DESC";
		query(sql, null, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=new ArrayList<>();
				while(rs.next()){
					Comment c = new Comment();
					c.setHcId(rs.getLong(1));
					c.setHcReply(rs.getString(2));
					c.setHcContent(rs.getString(3));
					c.setHcCreateTime(rs.getDate(4));
					c.setHcReplyTime(rs.getDate(5));
					c.setHcNickName(rs.getString(6));
					c.setHcState(rs.getString(7));
					list.add(c);
				}
			}
		});
		return list;
	}

}
