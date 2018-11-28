package com.oracleoaec.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.Util.JDBCTemplate;
import com.oracleoaec.Util.PreparedStatementSetter;
import com.oracleoaec.Util.RsCallBackHandler;
import com.oracleoaec.dao.OrderDao;
import com.oracleoaec.entity.Order;

public class OrderDaoImpl extends JDBCTemplate implements OrderDao{
	private List<Order> list=null;
	private Order order=null;
	
	@Override
	public int addOrder(final Order order) {
		String sql="INSERT INTO HWUA_ORDER VALUES (SEQ_ORDER.NEXTVAL,?,?,?,?,?,?,?)";
		int res = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, order.getHoUserId());
				ps.setString(2, order.getHoUserName());
				ps.setString(3, order.getHoUserAddress());
				ps.setDate(4, order.getHoCreateTime());
				ps.setDouble(5, order.getHoCost());
				ps.setLong(6, order.getHoStatus());
				ps.setLong(7, order.getHoType());
			}
		});
		return res;
	}

	@Override
	public List<Order> searchAllOrder(final Long hoUserId) {
		String sql="SELECT * FROM HWUA_ORDER WHERE HO_USER_ID=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hoUserId);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=new ArrayList<>();
				while(rs.next()){
					Order o = new Order();
					o.setHoId(rs.getLong(1));
					o.setHoUserId(rs.getLong(2));
					o.setHoUserName(rs.getString(3));
					o.setHoUserAddress(rs.getString(4));
					o.setHoCreateTime(rs.getDate(5));
					o.setHoCost(rs.getDouble(6));
					o.setHoStatus(rs.getLong(7));
					o.setHoType(rs.getLong(8));
					list.add(o);
				}
				
			}
		});
		return list;
	}

	@Override
	public Order searchOrderById(final Long hoId) {
		String sql="SELECT * FROM HWUA_ORDER WHERE HO_ID=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hoId);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					order=new Order();
					order.setHoId(rs.getLong(1));
					order.setHoUserId(rs.getLong(2));
					order.setHoUserName(rs.getString(3));
					order.setHoUserAddress(rs.getString(4));
					order.setHoCreateTime(rs.getDate(5));
					order.setHoCost(rs.getDouble(6));
					order.setHoStatus(rs.getLong(7));
					order.setHoType(rs.getLong(8));
				}
				
			}
		});
		return order;
	}

	@Override
	public int updateOrder(final Long hoId, final Long hoStatus) {
		String sql="UPDATE HWUA_ORDER SET HO_STATUS=? WHERE HO_ID=?";
		int res = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hoStatus);
				pstmt.setLong(2, hoId);
			}
		});
		return res;
	}

	@Override
	public int deleteOrder(final Long hoId) {
		String sql="DELETE FROM HWUA_ORDER WHERE HO_ID=?";
		int res = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hoId);
				
			}
		});
		return res;
	}

}
