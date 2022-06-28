package com.datit.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.datit.conn.JDBCUtils;

public class TaskDAO {
	private static String SELECT_ALL_TASKS = "SELECT * FROM tasks WHERE user = ?";
	private static String SELECT_BY_ID = "SELECT * FROM tasks WHERE id = ?";
	private static String INSERT = "INSERT INTO " + "tasks(title,description,target_time,status,user)"
									+ "VALUES(?,?,?,?,?)";
	private static String UPDATE = "UPDATE tasks SET title=?,description=?,target_time=?,status=? WHERE id = ?";
	private static String DELETE = "DELETE FROM tasks WHERE id = ?";

	public List<Task> getAllTaskOfUser(String username) {
		List<Task> tasks = null;
		try (Connection cnt = JDBCUtils.getConnection()) {
			PreparedStatement psmt = cnt.prepareStatement(SELECT_ALL_TASKS);
			psmt.setString(1, username);
			ResultSet rs = psmt.executeQuery();
			tasks = new ArrayList<Task>();
			while (rs.next()) {
				Task t = new Task();
				t.setId(rs.getLong("id"));
				t.setTitle(rs.getString("title"));
				t.setDescription(rs.getString("description"));
				t.setTarget_time(rs.getDate("target_time"));
				t.setStatus(rs.getBoolean("status"));
				t.setUser(rs.getString("user"));
				tasks.add(t);
			}
		} catch (SQLException ex) {
			JDBCUtils.printSQLException(ex);
		}
		return tasks;
	}

	public Task getTaskById(long id) {
		Task t = null;
		try (Connection cnt = JDBCUtils.getConnection()) {
			PreparedStatement psmt = cnt.prepareStatement(SELECT_BY_ID);
			psmt.setLong(1, id);
			System.out.println(psmt);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				t = new Task();
				t.setId(rs.getLong("id"));
				t.setTitle(rs.getString("title"));
				t.setDescription(rs.getString("description"));
				t.setTarget_time(rs.getDate("target_time"));
				t.setUser(rs.getString("user"));
				t.setStatus(rs.getBoolean("status"));
			}
		} catch (SQLException ex) {
			JDBCUtils.printSQLException(ex);
		}
		return t;
	}

	public boolean insertNewTask(Task t) {
		boolean success = false;
		try (Connection cnt = JDBCUtils.getConnection()) {
			PreparedStatement psmt = cnt.prepareStatement(INSERT);
			psmt.setString(1, t.getTitle());
			psmt.setString(2, t.getDescription());
			psmt.setBoolean(4, t.isStatus());
			psmt.setDate(3, t.getTarget_time());
			psmt.setString(5, t.getUser());
			System.out.println(psmt);
			// Execute query
			success = psmt.executeUpdate() > 0;

		} catch (SQLException ex) {
			JDBCUtils.printSQLException(ex);
		}
		return success;
	}

	public boolean updateTask(Task t) {
		boolean success = false;
		try (Connection cnt = JDBCUtils.getConnection()) {
			PreparedStatement psmt = cnt.prepareStatement(UPDATE);
			psmt.setString(1, t.getTitle());
			psmt.setString(2, t.getDescription());
			psmt.setDate(3, t.getTarget_time());
			psmt.setBoolean(4, t.isStatus());
			psmt.setLong(5, t.getId());
			success = psmt.executeUpdate() > 0;
		} catch (SQLException ex) {
			JDBCUtils.printSQLException(ex);
		}
		return success;
	}

	public boolean deleteTask(long id) {
		boolean success = false;
		try (Connection cnt = JDBCUtils.getConnection()) {
			PreparedStatement psmt = cnt.prepareStatement(DELETE);
			psmt.setLong(1, id);
			success = psmt.executeUpdate() > 0;
		} catch (SQLException ex) {
			JDBCUtils.printSQLException(ex);
		}
		return success;
	}

}
