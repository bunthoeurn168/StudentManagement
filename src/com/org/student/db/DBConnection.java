package com.org.student.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection conn;
	private static DBConnection dbConnection;
	
	private DBConnection() throws SQLException{
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/score", "postgres", "123");
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public static DBConnection getDBConnection() throws SQLException{
		if(dbConnection == null){
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
}
