package com.csd65.jspapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.csd65.jspapp.config.DbConfiguration;

public class SignupServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		
		String email = req.getParameter("u-email").toString();
		String password = req.getParameter("u-pass").toString();
		String username = req.getParameter("u-username").toString();
		String role = req.getParameter("u-role").toString();
		
		//Encrypting password with SHA-1 
		String enc_password = DigestUtils.sha1Hex(password);	
		
		
		try {
			Connection conn = DbConfiguration.getDatabaseConnection();
			String sql = "INSERT INTO `tbl_user` (`email`, `password`, `username`, `role`) VALUES (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, email);
			stmt.setString(2, enc_password);
			stmt.setString(3, username);
			stmt.setString(4, role);
			
			int affectedRows = stmt.executeUpdate();
			
			if(affectedRows > 0) {
				//System.out.println("Rows "+ affectedRows);
				res.sendRedirect("login.jsp");
			} else {
				//System.out.print("Inavlid records");
				session.setAttribute("error", "Invalid records");
				res.sendRedirect("error.jsp");
			}
			
		} catch (Exception e) {
			//System.out.println("ERROR : "+e.getMessage());
			session.setAttribute("error", "ERROR : "+e.getMessage());
			res.sendRedirect("error.jsp");
		}
		
	}

}
