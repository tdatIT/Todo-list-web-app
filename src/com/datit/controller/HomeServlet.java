package com.datit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1360356860068436088L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/htmt");
//		resp.sendRedirect("index.html");
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
		dispatcher.forward(req, resp);
	}
}
