package com.oracleoaec.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RsCallBackHandler {
	/**
	 * 处理结果集的一个回调函数(查询)
	 * @param rs
	 * @throws SQLException
	 */
   public void processRs(ResultSet rs)throws SQLException;
}
