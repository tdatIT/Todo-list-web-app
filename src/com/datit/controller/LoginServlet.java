package com.datit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.datit.model.Account;
import com.datit.model.AccountDAO;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -7249650215810938210L;
	private AccountDAO accDao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		accDao = new AccountDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("html");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		
		if(username!=null) {
			resp.sendRedirect("list");
		}else
			req.getRequestDispatcher("HTML_JSP/login.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("html");
		resp.setCharacterEncoding("utf-8");
		//business logic
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		Account acc = accDao.login(username, pass);
		if(acc!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", acc.getUsername());
			session.setAttribute("name", acc.getName());
			resp.sendRedirect("list");
		}else {
			req.setAttribute("NOTIFY", "FAIL");
			RequestDispatcher dispatcher  = req.getRequestDispatcher("HTML_JSP/login.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
