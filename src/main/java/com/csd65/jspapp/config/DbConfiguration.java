package com.csd65.jspapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfiguration {
	
	private final static String driverClassName= "com.mysql.cj.jdbc.Driver";
	private final static String databaseURL = "jdbc:mysql://192.168.64.2:3306/posts_db";
	private final static String databaseUsername = "sahan";
	private final static String databasePassword = "mysql";
	
	public static Connection getDatabaseConnection() throws ClassNotFoundException {
		Class.forName(driverClassName);
		try {
			Connection connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
