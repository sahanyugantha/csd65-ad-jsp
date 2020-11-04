package com.csd65.jspapp;

import java.io.IOException;
import java.net.HttpCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThemeChangeServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Cookie themeCookie = new Cookie("theme", "Light");
		themeCookie.setMaxAge(60*60*24*7*4);
		res.addCookie(themeCookie);
		
		String u_theme = req.getParameter("theme");
		
		System.out.println("u_theme ---> "+u_theme);
		
		
		if(u_theme.equals("Dark")) {
			
			themeCookie.setValue("Dark");
			res.addCookie(themeCookie);
			
			System.out.println("Dark Theme ---> "+u_theme);
		} else {
			System.out.println("Dark Theme ---> False");
		}
		
		
		//System.out.println("New Theme ---> "+u_theme);
		
		
		res.sendRedirect("index.jsp");
		
	}
	

}
