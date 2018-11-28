package com.oracleoaec.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 获取数据库链接之后的增删改操作和查询操作以及关闭操作
 */
public class JDBCTemplate {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	/**
	 * 关闭链接，必须有的操作
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 增删改操作
	 * @param sql
	 * @param setter
	 * @return 成功则大于0
	 */
	public int update(String sql, PreparedStatementSetter setter){
		int res = 0;// 影响的行数
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(ps);//占位符
			}
			conn.setAutoCommit(false);// 事务处理，将自动提交设置为false，改为手动提交
			res = ps.executeUpdate();
			conn.commit();//增删改成功之后，提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();//失败后回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			closeAll(null, ps, conn);
		}
		return res;
	}

	/**
	 * 执行查询语句
	 * @param sql
	 * @param setter
	 * @param handler
	 */
	public void query(String sql, PreparedStatementSetter setter, RsCallBackHandler handler) {
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(ps);// 替换占位符
			}
			rs = ps.executeQuery();// 执行查询语句
			if (handler != null) {
				handler.processRs(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
	}
}
