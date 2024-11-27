package com.rakshith.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "tiger";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded Successfully!!");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Drivers Failed to Load!!");
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
