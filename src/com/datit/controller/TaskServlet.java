package com.datit.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.datit.model.Task;
import com.datit.model.TaskDAO;

@WebServlet(urlPatterns = {"/list","/new","/edit","/insert","/update","/delete"})
public class TaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1145845187239104202L;
	private TaskDAO taskDao;
	private static HttpSession session;
	private static String user;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		taskDao = new TaskDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		session = req.getSession();
		user = (String) session.getAttribute("username");
		if (user != null) {
			String action = req.getServletPath();
			try {
				switch (action) {
				case "/new": {
					showNewForm(req, resp);
				}
					break;
				case "/insert": {
					insertTask(req, resp);
				}
					break;
				case "/delete": {
					deleteTask(req, resp);
				}
					break;
				case "/update": {
					updateTask(req, resp);
				}
					break;
				case "/list": {
					listTask(req, resp);
				}
					break;
				case "/edit": {
					showEditForm(req, resp);
				}
					break;
				}	
			} catch (SQLException ex) {
				// TODO: handle exception
				throw new ServletException(ex);
			}
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("HTML_JSP/login.jsp");
			dispatcher.forward(req, resp);
		}
		

	}

	private void listTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Task> tasks = taskDao.getAllTaskOfUser(user);
		req.setAttribute("tasks", tasks);
		RequestDispatcher dispatcher = req.getRequestDispatcher("HTML_JSP/todo-list.jsp");
		dispatcher.forward(req, resp);
	}

	private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("HTML_JSP/todo-form.jsp");
		dispatcher.forward(req, resp);
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		Task existingTask = taskDao.getTaskById(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("HTML_JSP/todo-form.jsp");
		req.setAttribute("task", existingTask);
		dispatcher.forward(req, resp);
	}

	private void insertTask(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		boolean status = Boolean.valueOf(req.getParameter("status"));
		Date target_time = Date.valueOf(req.getParameter("target_time"));
		
		Task task = new Task();
		task.setTitle(title);
		task.setDescription(description);
		task.setStatus(status);
		task.setTarget_time(target_time);
		task.setUser(user);

		taskDao.insertNewTask(task);
		resp.sendRedirect("list");
	}

	private void updateTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// get value from view
		Long id = Long.parseLong(req.getParameter("id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		boolean status = Boolean.valueOf(req.getParameter("status"));
		Date target_time = Date.valueOf(req.getParameter("target_time"));
		// create new object of class Task
		Task task = new Task();
		task.setId(id);
		task.setTitle(title);
		task.setDescription(description);
		task.setStatus(status);
		task.setTarget_time(target_time);
		task.setUser(user);
		// call method update
		taskDao.updateTask(task);
		resp.sendRedirect("list");
	}

	private void deleteTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		long id = Long.parseLong(req.getParameter("id"));
		taskDao.deleteTask(id);
		resp.sendRedirect("list");
	}

}
