package com.test.basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.conn.ConnectionUtils;

public class QueryDataExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Lấy ra đối tượng Connection kết nối vào DB.
		Connection connection = ConnectionUtils.getMyConnection();

		// Tạo đối tượng Statement.
		Statement statement = connection.createStatement();

		String sql = "Select * from USER_ACCOUNT";

		// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);

		// Duyệt trên kết quả trả về.
		while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
			System.out.println("--------------------");
			System.out.println("EmpName:" + rs.getString("USER_NAME"));
			System.out.println("GENDER:" + rs.getString("GENDER"));
			System.out.println("PASSWORD:" + rs.getString("PASSWORD"));
		}
		// Đóng kết nối
		connection.close();
	}

}
