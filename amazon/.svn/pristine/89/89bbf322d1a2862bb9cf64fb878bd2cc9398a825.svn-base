package com.oracleoaec.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.Util.JDBCTemplate;
import com.oracleoaec.Util.PreparedStatementSetter;
import com.oracleoaec.Util.RsCallBackHandler;
import com.oracleoaec.dao.OrderDetailDao;
import com.oracleoaec.entity.OrderDetail;

public class OrderDetailDaoImpl extends JDBCTemplate implements OrderDetailDao{

	private List<Long> list=null;
	private Long orderId=0l;
	
	@Override
	public int addOrderDetail(final OrderDetail orderDetail) {
		String sql="INSERT INTO HWUA_ORDER_DETAIL VALUES(SEQ_DETAIL.NEXTVAL,?,?,?,?)";
		int update = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, orderDetail.getHodId());
				pstmt.setLong(2, orderDetail.getHpId());
				pstmt.setLong(3, orderDetail.getHodQuantity());
				pstmt.setDouble(4, orderDetail.getHodCost());
			}
		});
		return update;
	}

	@Override
	public List<Long>  hotProducts(final int rownum) {
		String sql="SELECT HP_ID FROM (SELECT  HP_ID,COUNT(HP_ID)TIME  FROM HWUA_ORDER_DETAIL GROUP BY HP_ID ORDER BY TIME  DESC) WHERE ROWNUM<=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, rownum);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=new ArrayList<>();
				while(rs.next()){
					list.add(rs.getLong(1));
				}
				
			}
		});
		return list;
	}

	@Override
	public Long getOrderId() {
		String sql="SELECT SEQ_ORDER.NEXTVAL-1 FROM DUAL";
		query(sql, null, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					orderId=rs.getLong(1);
				}
				
			}
		});
		return orderId;
	}

}
