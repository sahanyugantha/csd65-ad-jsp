package com.csd65.jspapp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		
		HttpSession session = req.getSession();
		session.removeAttribute("u_id");
		session.removeAttribute("u_email");
		session.removeAttribute("u_username");
		session.removeAttribute("u_role");
		session.setAttribute("logged_in", false);
		
		res.sendRedirect("index.jsp");
	}

}
