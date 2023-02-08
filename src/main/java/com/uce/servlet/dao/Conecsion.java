package com.uce.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecsion {
	private String base = "servlets";
	private String user = "root";
	private String password = "admuser";
	private String timeZone = "serverTimezone=UTC";
	private String url = "jdbc:mysql://localhost:3306/" + base + "?" + timeZone;	
	private Connection  con = null;

	public Connection getConecsion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			e.printStackTrace();
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}



