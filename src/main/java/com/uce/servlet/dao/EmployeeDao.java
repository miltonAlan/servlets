package com.uce.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.uce.servlet.modelo.Employee;

public class EmployeeDao {
	private String base = "servlets";
	private String user = "root";
	private String password = "admuser";
	private String url = "jdbc:mysql://localhost:3306/" + base + "?&serverTimezone=UTC";
	private Connection con = null;

	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employee"
				+ "  (first_name, last_name, username, password, address, contact) VALUES " + " (?, ?, ?, ?,?,?);";

		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setString(6, employee.getContact());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// process sql exception
			this.printSQLException(e);
		}
		return result;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}