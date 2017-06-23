package com.test.servlet;

import java.sql.Connection;
import java.sql.SQLException;

import com.test.conn.MySQLConnUtils;

public class ConnectionUtils {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// Ở đây tôi kết nối tới Oracle Database.
		// (Bạn có thể thay đổi sử dụng database khác).
		return MySQLConnUtils.getMySQLConnection();

		// return MySQLConnUtils.getMySQLConnection();
		// return SQLServerConnUtils_JTDS.getSQLServerConnection_JTDS();
		// return SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
	}

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
		}
	}
}