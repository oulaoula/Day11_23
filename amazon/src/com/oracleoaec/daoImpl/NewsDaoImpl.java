package com.oracleoaec.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.Util.JDBCTemplate;
import com.oracleoaec.Util.PreparedStatementSetter;
import com.oracleoaec.Util.RsCallBackHandler;
import com.oracleoaec.dao.NewsDao;
import com.oracleoaec.entity.News;

public class NewsDaoImpl extends JDBCTemplate implements NewsDao{
	private List<News> list=null;
	private News news=null;
	
	@Override
	public List<News> getNews(final int rownum) {
		String sql="SELECT * FROM HWUA_NEWS WHERE ROWNUM<=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, rownum);
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=new ArrayList<>();
				while(rs.next()){
					News news = new News();
					news.setHnId(rs.getLong(1));
					news.setHnTitle(rs.getString(2));
					list.add(news);
				}
				
			}
		});
		return list;
	}
	
	@Override
	public News getNewsById(final Long hnId) {
		String sql="SELECT * FROM HWUA_NEWS WHERE HN_ID=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hnId);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					news = new News();
					news.setHnId(rs.getLong(1));
					news.setHnTitle(rs.getString(2));
					news.setHnContent(rs.getString(3));
					news.setHnCreateTime(rs.getDate(4));
				}
				
			}
		});
		return news;
	}

}
