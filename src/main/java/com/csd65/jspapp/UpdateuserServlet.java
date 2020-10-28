package com.csd65.jspapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.csd65.jspapp.config.DbConfiguration;

public class UpdateuserServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		
		String email = req.getParameter("u-email").toString();
		String password = req.getParameter("u-pass").toString();
		String username = req.getParameter("u-username").toString();
		String role = req.getParameter("u-role").toString();
		
		int id = (Integer)session.getAttribute("u_id");
		
		try {
			
			Connection conn = DbConfiguration.getDatabaseConnection();
			String sql = "UPDATE `tbl_user` SET "
							+ "	`email` = ?, `password` = ?, `username` = ?, `role` = ?"
							+ "WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			stmt.setString(3, username);
			stmt.setString(4, role);
			stmt.setInt(5, id);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows > 0) {
				res.sendRedirect("login.jsp");
			} else {
				session.setAttribute("error", "Invalid records");
				res.sendRedirect("error.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "ERROR : "+e.getMessage());
			res.sendRedirect("error.jsp");
		}
	}

}
