package com.oracleoaec.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.Util.JDBCTemplate;
import com.oracleoaec.Util.PreparedStatementSetter;
import com.oracleoaec.Util.RsCallBackHandler;
import com.oracleoaec.dao.CartDao;
import com.oracleoaec.entity.Cart;

public class CartDaoImpl extends JDBCTemplate implements CartDao{
	private int count=0;
	private Cart c=null;
	private List<Integer> countList=null;
	private List<Cart> list=null;
	
	public int addCart(final Cart cart) {
		String sql="INSERT INTO HWUA_CART VALUES(SEQ_CART.NEXTVAL,?,?,?)";
		int res = update(sql, new PreparedStatementSetter() {
			
			
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, cart.getPid());
				ps.setLong(2, cart.getQuantity());
				ps.setLong(3, cart.getUserId());
			}
		});
		return res;
	}

	public int updateCart(final Cart cart) {
		String sql="UPDATE HWUA_CART SET QUANTITY=? WHERE ID=?";
		int res = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, cart.getQuantity());
				ps.setLong(2, cart.getId());
			}
		});
		return res;
	}

	public Cart checkCart(final Cart cart) {
		String sql="SELECT * FROM HWUA_CART WHERE PID=? AND USERID=?";
	  
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, cart.getPid());
				ps.setLong(2, cart.getUserId());
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					c = new Cart();
					c.setId(rs.getLong(1));
					c.setPid(rs.getLong(2));
					c.setQuantity(rs.getLong(3));
					c.setUserId(rs.getLong(4));
				}
			}
		});
		return c;
	}

	public List<Integer> updateCartCount(final Long userId) {
		String sql="SELECT QUANTITY FROM HWUA_CART WHERE USERID=?";
		 
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, userId);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				countList=new ArrayList<>();
				while(rs.next()){
					count=rs.getInt(1);
					countList.add(count);
				}
			}
		});
		return countList;
	}

	public List<Cart> usersCarts(final Long userId) {
		String sql="SELECT ID,PID,QUANTITY FROM HWUA_CART WHERE USERID=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, userId);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=new ArrayList<>();
				while(rs.next()){
					Cart cart = new Cart();
					cart.setId(rs.getLong(1));
					cart.setPid(rs.getLong(2));
					cart.setQuantity(rs.getLong(3));
					list.add(cart);
				}
				
			}
		});
		return list;
	}

	public int deleteCarts(final Long userId) {
		String sql="DELETE FROM HWUA_CART WHERE USERID=?";
		int res = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, userId);
				
			}
		});
		return res;
	}

	public int deleteCartById(final String ID) {
		String sql="DELETE FROM HWUA_CART WHERE ID=?";
		int res = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, ID);
			}
		});
		return res;
	}

	public int alertCartQuantity(final String id, final String quantity) {
		String sql="UPDATE HWUA_CART SET QUANTITY=? WHERE ID=?";
		int res = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, quantity);
				pstmt.setString(2, id);
			}
		});
		return res;
	}

}
