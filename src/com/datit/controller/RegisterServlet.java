package com.datit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datit.model.Account;
import com.datit.model.AccountDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -9104175243960646795L;
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
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.sendRedirect("HTML_JSP/register.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		// business logic
		Account acc = new Account();
		acc.setUsername(username);
		acc.setPass(pass);
		acc.setName(name);

		if (accDao.insertNewAccount(acc)) {
			req.setAttribute("NOTIFY", "SUCCESS");
		} else {
			req.setAttribute("NOTIFY", "FAIL");
		}
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("HTML_JSP/register.jsp");
		dispatcher.forward(req, resp);
	}

}
