package com.cell2iwebservice.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseOpener {
	private static String DBUsername = "cell2i";
	private static String DBPassword = "cell2iapp";
	private static String DBName     = "xe";
	private static String DBUrl      = "209.97.129.103";
	private static String DBPort     = "1521";	
	private static String DBDriver   = "oracle.jdbc.driver.OracleDriver";
	
	
	private static String makeConnectionString() {
		return "jdbc:oracle:thin:" + DBUsername + "/" + DBPassword + "@" + DBUrl + ":" + DBPort + ":" + DBName ;
	}
	
	public static Connection open() {
		return open(DBUsername, DBPassword, DBName, DBUrl);
	}
	
	public static Connection open(String DBUsername, String DBPassword) {
		return open(DBUsername, DBPassword, DBUrl, DBName);
	}
	
	public static Connection open(String DBUsername, String DBPassword, String DBName) {
		return open(DBUsername, DBPassword, DBName, DBUrl);
	}
	
	public static Connection open(String DBUsername, String DBPassword, String DBName, String DBUrl) {
		Connection con = null;
		try {
			Class.forName(DBDriver).newInstance();
			con = DriverManager.getConnection( makeConnectionString() , DBUsername, DBPassword);            
			// System.out.println("Connection established for SQL");
		} catch(Exception e) {
			// bu yorum olarak kalacak!
			// System.out.println("Database connection exception=" + e);
			System.out.println("Database Connection Error!\n" + DBUrl + " "+ DBName + "\n" + e);
		}        
		return con;
	}
}