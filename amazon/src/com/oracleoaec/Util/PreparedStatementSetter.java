package com.oracleoaec.Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	/**
	 * 回调函数，获取值来替换占位符
	 * @param pstmt
	 * @throws SQLException
	 */
	public void setValues(PreparedStatement pstmt) throws SQLException;
}
