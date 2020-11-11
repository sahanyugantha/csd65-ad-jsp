package com.csd65.jspapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.csd65.jspapp.config.DbConfiguration;

public class LoginServlet extends HttpServlet{
	
	private HttpSession session = null; 
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		session = req.getSession();
		
		String email = req.getParameter("u-email").toString();
		String password = req.getParameter("u-pass").toString();
		
		//Encrypting the password with SHA-1
		String encr_password = DigestUtils.sha1Hex(password);
		
		//Creating Cookies.
		Cookie sample = new Cookie("sample", "yummy");
		sample.setMaxAge(60*60); // two minutes.
		res.addCookie(sample);
		
		int response = loginChecker(email, encr_password);
		
		if(response > 0) {
			//Login Success.
			res.sendRedirect("index.jsp");
		} else if(response == 0) {
			//Login Failed.
			res.sendRedirect("login.jsp");
		} else {
			//Error.
			res.sendRedirect("error.jsp");
		}
		
		
		
	}
	
	
	public int loginChecker(String email, String encr_password) {

		try {
			Connection conn = DbConfiguration.getDatabaseConnection();
			//Preparing the query
			String sql = "SELECT * FROM tbl_user WHERE email=? AND password=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, email);
			stmt.setString(2, encr_password);
			
			
			ResultSet rs = stmt.executeQuery();
			
			//Check the number of rows in result set(virtual table)
			int rows = 0;
			while(rs.next()) {
				rows++;
				
				if(session != null) {
					session.setAttribute("u_id", rs.getInt("id"));
					session.setAttribute("u_email", rs.getString("email"));
					session.setAttribute("u_pass", rs.getString("password"));
					session.setAttribute("u_username", rs.getString("username"));
					session.setAttribute("u_role", rs.getString("role"));
					session.setAttribute("logged_in", true);
				}
			}		
			
			
			if(rows > 0) {
								
				//Successfully logged in
				return rows; //or we can return the 1.
		
			} else {
				session.setAttribute("error", "Invalid email or password");
			}
			
			//Close connection
			conn.close();
			return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			String errMsg = "ERROR : "+e.getMessage();
			session.setAttribute("error", errMsg);
			
			return -1;
			
		}
	}
	
	
	
	
	
	//Sample method for test
	public int addTwoNumbers(int num1, int num2) {
		
		int total = num1 + num2;
		return total;
	}

}
