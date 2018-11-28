package com.oracleoaec.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracleoaec.Util.JDBCTemplate;
import com.oracleoaec.Util.PreparedStatementSetter;
import com.oracleoaec.Util.RsCallBackHandler;
import com.oracleoaec.dao.UserDao;
import com.oracleoaec.entity.HwuaUser;

public class UserDaoImpl extends JDBCTemplate implements UserDao{
	
	private Long id=0l;
	private HwuaUser user=null;
	private String pwd=null;
	@Override
	public int saveUser(final HwuaUser user) {
		String sql="INSERT INTO HWUA_USER VALUES(SEQ_USER.NEXTVAL,?,?,?,?,?,?,?,?,?)";
		int result = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getSex());
				ps.setDate(4, user.getBirthday());
				ps.setString(5, user.getIdentityCode());
				ps.setString(6, user.getEmail());
				ps.setString(7, user.getMobile());
				ps.setString(8, user.getAddress());
				ps.setInt(9, 1);
			}
		});
		return result;
	}

	@Override
	public Long checkName(final String username) {
		String sql="SELECT HU_USER_ID FROM HWUA_USER WHERE HU_USER_NAME=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, username);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					id=rs.getLong(1);
				}
			}
		});
		return id;
	}

	@Override
	public HwuaUser checkUser(final String username, final String password) {
		String sql="SELECT * FROM HWUA_USER WHERE HU_USER_NAME=? AND HU_PASSWORD=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					user=new HwuaUser();
					user.setUserId(rs.getLong(1));
					user.setUserName(rs.getString(2));
					user.setAddress(rs.getString("HU_ADDRESS"));
					
				}
				
			}
		});
		return user;
	}

	@Override
	public Long checkEmail(final String email) {
		String sql="SELECT HU_USER_ID FROM HWUA_USER WHERE HU_EMAIL=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, email);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					id=rs.getLong(1);
				}
			}
		});
		return id;
	}
	public String findPwd(final String name,final String email) {
		String sql="SELECT HU_PASSWORD FROM HWUA_USER WHERE HU_EMAIL=? AND HU_USER_NAME=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, email);
				ps.setString(2, name);
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					pwd=rs.getString(1);
				}
			}
		});
		return pwd;
	}

}
