package com.oracleoaec.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.Util.JDBCTemplate;
import com.oracleoaec.Util.PreparedStatementSetter;
import com.oracleoaec.Util.RsCallBackHandler;
import com.oracleoaec.dao.ProductDao;
import com.oracleoaec.entity.Product;

public class ProductDaoImpl extends JDBCTemplate implements ProductDao{
	private List<Product> list=new ArrayList<>();
	private Product p=null;
	private int count=0;
	@Override
	public List<Product> findProducts(final int stsrtNum,final int endNum){
		String sql="select p.* from (select rownum as rn,HP_NAME,HP_PRICE,HP_FILE_NAME,HP_ID from HWUA_PRODUCT order by HP_ID) p"
				+ "	where p.rn >=? and p.rn<=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, stsrtNum);
				pstmt.setInt(2, endNum);
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=getProducts(rs);
				
			}
		});
		return list;
	}
	@Override
	public Product findProductById(final Long hpId) {
		String sql="SELECT * FROM HWUA_PRODUCT WHERE HP_ID=? order by hp_id desc";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hpId);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					p=new Product();
					p.setHpId(rs.getLong(1));
					p.setHpName(rs.getString(2));
					p.setHpDescription(rs.getString(3));
					p.setHpPrice(rs.getDouble(4));
					p.setHpStock(rs.getLong(5));
					p.setHpcId(rs.getLong(6));
					p.setHpcChildId(rs.getLong(7));
					p.setHpFileName(rs.getString(8));
				}
				
			}
		});
		return p;
	}
	@Override
	public List<Product> productByParentCategory(final int parentId,final int stsrtNum,final int endNum) {
		String sql="SELECT P.* FROM(SELECT ROWNUM AS RN, HP_NAME,"
				+ "HP_PRICE,HP_FILE_NAME,HP_ID FROM HWUA_PRODUCT WHERE HPC_ID=?)P WHERE P.RN>=? AND P.RN<=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, parentId);
				pstmt.setInt(2, stsrtNum);
				pstmt.setInt(3, endNum);
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=getProducts(rs);
				
			}
		});
		return list;
	}
	@Override
	public List<Product> productByChildCategory(final int childId,final int stsrtNum,final int endNum) {
		String sql="SELECT P.* FROM(SELECT ROWNUM AS RN, HP_NAME,"
				+ "HP_PRICE,HP_FILE_NAME,HP_ID FROM HWUA_PRODUCT WHERE HPC_CHILD_ID=?)P WHERE P.RN>=? AND P.RN<=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, childId);
				pstmt.setInt(2,stsrtNum);
				pstmt.setInt(3,endNum);
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=getProducts(rs);
				
			}
		});
		return list;
	}

	
	
	private List<Product> getProducts(ResultSet rs) throws SQLException{
		List<Product> list=new ArrayList<>();
		while(rs.next()){
			Product p = new Product();
			p.setHpId(rs.getLong("HP_ID"));
			p.setHpName(rs.getString("HP_NAME"));
			p.setHpPrice(rs.getDouble("HP_PRICE"));
			p.setHpFileName(rs.getString("HP_FILE_NAME"));
			list.add(p);
		}
		 return list;
	 }
	@Override
	public int changeStock(final Long hpStock,final Long hpId) {
		String sql="UPDATE HWUA_PRODUCT SET HP_STOCK=? WHERE HP_ID=?";
		int update = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hpStock);
				pstmt.setLong(2, hpId);
			}
		});
		return update;
	}
	
	
	
	
	
	
	public int resetStock(final Long hpStock) {
		String sql="UPDATE HWUA_PRODUCT SET HP_STOCK=? ";
		int update = update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hpStock);
				
			}
		});
		return update;
	}
	
	
	
	@Override
	public int findProducts() {
		String sql="SELECT COUNT(HP_ID) FROM HWUA_PRODUCT";
		query(sql, null, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					count=rs.getInt(1);
				}
				
			}
		});
		return count;
	}
	@Override
	public int productByParentCategory(final int parentId) {
		String sql="SELECT COUNT(HP_ID) FROM HWUA_PRODUCT WHERE HPC_ID=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, parentId);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					count=rs.getInt(1);
				}
				
			}
		});
		return count;
	}
	@Override
	public int productByChildCategory(final int childId) {
		String sql="SELECT COUNT(HP_ID) FROM HWUA_PRODUCT WHERE HPC_CHILD_ID=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, childId);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					count=rs.getInt(1);
				}
				
			}
		});
		return count;
	}
	@Override
	public List<Product> queryProducts(final String qname,final int stsrtNum,final int endNum) {
		String sql="SELECT P.* FROM(SELECT ROWNUM AS RN, HP_NAME,"
				+ "HP_PRICE,HP_FILE_NAME,HP_ID FROM HWUA_PRODUCT WHERE HP_NAME LIKE ?)P WHERE P.RN>=? AND P.RN<=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, "%"+qname+"%");
				pstmt.setInt(2, stsrtNum);
				pstmt.setInt(3, endNum);
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				list=getProducts(rs);
				
			}
		});
		return list;
	}
	@Override
	public int countQueryProducts(final String qname) {
		
		String sql="SELECT COUNT(HP_ID) FROM HWUA_PRODUCT WHERE HP_NAME LIKE ?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, "%"+qname+"%");
				
			}
		}, new RsCallBackHandler() {
			
			@Override
			public void processRs(ResultSet rs) throws SQLException {
				if(rs.next()){
					count=rs.getInt(1);
				}
				
			}
		});
		return count;
	}
	
	
}





 














