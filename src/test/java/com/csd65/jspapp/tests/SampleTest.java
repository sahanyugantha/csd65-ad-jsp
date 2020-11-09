package com.csd65.jspapp.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.csd65.jspapp.LoginServlet;

public class SampleTest {
	
	/**
	 * Sample test for adding two numbers
	 * 10 + 15 and observe
	 */
	
	//Arrange
	private int expected = 25; //Expected outcome
	private int num1 = 10;
	private int num2 = 15;
	private LoginServlet loginServlet = new LoginServlet();
	
	//test method
	@Test
	public void testForAdd() {
		
		//Act
		int actual = loginServlet.addTwoNumbers(num1, num2);
		
		//Assert
		assertEquals(expected, actual);
		
	}

}
