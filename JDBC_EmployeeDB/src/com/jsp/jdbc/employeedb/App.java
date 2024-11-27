package com.jsp.jdbc.employeedb;

public class App {
	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.updateSalaryBetweenAge();
	}
}
