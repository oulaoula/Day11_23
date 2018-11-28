package com.oracleoaec.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.Util.JDBCTemplate;
import com.oracleoaec.Util.PreparedStatementSetter;
import com.oracleoaec.Util.RsCallBackHandler;
import com.oracleoaec.dao.CategoryDao;
import com.oracleoaec.entity.Category;

public class CategoryDaoImpl extends JDBCTemplate implements CategoryDao{

	private List<Category> list=null;
	private String hpcName="";
	
	public List<Category> parentCategory() {
		String sql="SELECT HPC_ID,HPC_NAME FROM HWUA_PRODUCT_CATEGORY WHERE HPC_ID=HPC_PARENT_ID";
		query(sql, null, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=new ArrayList<>();
				while(rs.next()){
					Category c = new Category();
					c.setHpcId(rs.getInt(1));
					c.setHpcName(rs.getString(2));
					list.add(c);
				}
				
			}
		});
		return list;
	}

	
	public List<Category> childCategory(final int hpcParentId) {
		String sql="SELECT HPC_ID,HPC_NAME FROM HWUA_PRODUCT_CATEGORY WHERE HPC_PARENT_ID=? AND HPC_ID!=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, hpcParentId);
				pstmt.setInt(2, hpcParentId);
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=new ArrayList<>();
				while(rs.next()){
					Category c = new Category();
					c.setHpcId(rs.getInt(1));
					c.setHpcName(rs.getString(2));
					list.add(c);
				}
			}
		});
		return list;
	}

	@Override
	public String categoryNameById(final Long hpcId) {
		String sql="SELECT HPC_NAME FROM HWUA_PRODUCT_CATEGORY WHERE HPC_ID=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hpcId);
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					hpcName=rs.getString(1);
				}
				
			}
		});
		return hpcName;
	}

}
