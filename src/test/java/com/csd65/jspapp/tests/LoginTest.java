package com.csd65.jspapp.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import com.csd65.jspapp.LoginServlet;

public class LoginTest {
	
	//Arrange
	private int expected = 1;
	private String email = "sahan@bcas.lk";
	private String encr_password = DigestUtils.sha1Hex("123");
	
	@Test
	public void LoginMethodTest() {
		//Act
		LoginServlet loginServlet = new LoginServlet();
		int actual = loginServlet.loginChecker(email, encr_password);
		
		//Assert
		assertEquals(expected, actual);
	}
	

}
