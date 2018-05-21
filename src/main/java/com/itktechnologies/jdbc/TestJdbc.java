package com.itktechnologies.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://192.168.0.35:3306/hb_student_tracker?useSSL=false";
		String user = "spring";
		String pass = "SuperSecret123!";
		
		try {
			System.out.println("Connecting to the database...");
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connected to the database - " + conn);
			
			conn.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
