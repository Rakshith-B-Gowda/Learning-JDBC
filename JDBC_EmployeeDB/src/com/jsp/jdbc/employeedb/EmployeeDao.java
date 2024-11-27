package com.jsp.jdbc.employeedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDao {
	
	public static Connection buildConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbc_employeedb", "root", "tiger");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;	
	}

	public void addEmployee() {
		Connection conn = buildConnection();
		String query = "INSERT INTO employee VALUES(102,'Prajwal','pra@gmail.com','Manager',23,45000)";
		try {
			Statement st = conn.createStatement();
			boolean rowsAffected = st.execute(query);
			if (rowsAffected == false) {
				System.out.println("Insertion Successful");
			} else {
				System.out.println("Insertion Failed!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateSalaryBetweenAge() {
		Connection connection = buildConnection();
		Scanner scanner = new Scanner(System.in);
		String selectQuery = "Select * FROM employee WHERE employeeAge BETWEEN ? AND ?";
		try {
			PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
			System.out.println("Enter the age range: ");
			selectStatement.setInt(1, scanner.nextInt());
			selectStatement.setInt(2, scanner.nextInt());
			ResultSet resultSet = selectStatement.executeQuery();
			while (resultSet.next()) {
				int employeeId = resultSet.getInt("employeeId");
				String updateQuery = "UPDATE employee SET employeeSalary = employeeSalary + 100000 WHERE employeeId = ?";
				PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
				updateStatement.setInt(1, employeeId);
				updateStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			scanner.close();
		}
	}
	public void findEmployeeById() {}
	public void updateEmployeeSalaryById() {}
	public void deleteEmployeeById() {
		
	}
}		