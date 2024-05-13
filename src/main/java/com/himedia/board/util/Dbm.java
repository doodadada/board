package com.himedia.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbm {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/board";
	private static String id = "root";
	private static String pass = "adminuser";

	public static Connection getConnection() {

		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con; // 연결 객체 리턴
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 전달받은 객체 close
	}
}
