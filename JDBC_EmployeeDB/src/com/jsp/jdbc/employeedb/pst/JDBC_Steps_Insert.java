package com.jsp.jdbc.employeedb.pst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Steps_Insert {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection connection = null;
		
		try {
			// Step 1:- Load & Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2:- Establish the Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb?user=root&password=tiger");
			
			// Step 3:- Create Statement
			String insertQuery = "INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			System.out.println("Enter ");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
