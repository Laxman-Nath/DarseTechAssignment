package com.bms.repositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class BookRepo {
	public static Connection getConnection() {
		try {
			System.out.println("inside connection..........");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/darsetech_db", "root", "siddha@123");
			
			return connection;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
