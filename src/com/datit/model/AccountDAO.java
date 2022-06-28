package com.datit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.datit.conn.JDBCUtils;

public class AccountDAO {

	public static String INSERT = "INSERT INTO accounts VALUES(?,?,?)";
	public static String LOGIN = "SELECT * FROM accounts WHERE username = ? AND pass = ?";

	public boolean insertNewAccount(Account acc) {
		boolean success = false;
		try (Connection cnt = JDBCUtils.getConnection()) {
			PreparedStatement psmt = cnt.prepareStatement(INSERT);
			psmt.setString(1, acc.getUsername());
			psmt.setString(2, acc.getPass());
			psmt.setString(3, acc.getName());
			System.out.println(psmt);
			success = psmt.executeUpdate() > 0;

		} catch (SQLException ex) {
			JDBCUtils.printSQLException(ex);
		}
		return success;
	}

	public Account login(String username, String pass) {
		Account acc = null;
		try (Connection cnt = JDBCUtils.getConnection()) {
			PreparedStatement psmt = cnt.prepareStatement(LOGIN);
			psmt.setString(1, username);
			psmt.setString(2, pass);
			System.out.println(psmt);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				acc = new Account();
				acc.setUsername(rs.getString("username"));
				acc.setPass(rs.getString("pass"));
				acc.setName(rs.getString("name"));
			}
		} catch (SQLException ex) {
			JDBCUtils.printSQLException(ex);
		}
		return acc;
	}
}
