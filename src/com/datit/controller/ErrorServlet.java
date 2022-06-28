package com.datit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

	private static final long serialVersionUID = 2607080443411050176L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Integer status_code = (Integer)req.getAttribute("javax.servlet.error.status_code");
		req.setAttribute("code_error", status_code);
		req.getRequestDispatcher("error-page.jsp").forward(req, resp);
	}
}
