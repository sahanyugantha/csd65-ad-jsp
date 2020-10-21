package com.csd65.jspapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		
		String email = req.getParameter("u-email").toString();
		String password = req.getParameter("u-pass").toString();
		
		
		try {
			//Set up MySQL Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Database URL
			String dbURL = "jdbc:mysql://localhost:3306/postsdb";
			Connection conn = DriverManager.getConnection(dbURL, "root", "mysql");
			
			//Preparing the query
			String sql = "SELECT * FROM tbl_user WHERE email=? AND password=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			//Check the number of rows in result set(virtual table)
			int rows = 0;
			while(rs.next()) {
				rows++;
				
				session.setAttribute("u_id", rs.getInt("id"));
				session.setAttribute("u_email", rs.getString("email"));
				session.setAttribute("u_username", rs.getString("username"));
				session.setAttribute("u_role", rs.getString("role"));
				session.setAttribute("logged_in", true);
			}
			
			
			if(rows > 0) {
				//Successfully logged in
				res.sendRedirect("index.jsp");
				
			} else {
				session.setAttribute("error", "Invalid email or password");
				res.sendRedirect("error.jsp");
			}
			
			//Close connection
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			String errMsg = "ERROR : "+e.getMessage();
			session.setAttribute("error", errMsg);
			
			res.sendRedirect("error.jsp");
		}
		
	}

}
