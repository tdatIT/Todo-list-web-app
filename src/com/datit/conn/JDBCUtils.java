package com.datit.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	public static String DB_USER = "root";
	public static String DB_PASS = "123456";
	public static String DB_URL = "jdbc:mysql://localhost:3306/todolist_app";

	public static Connection getConnection() {
		Connection cnt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnt = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}