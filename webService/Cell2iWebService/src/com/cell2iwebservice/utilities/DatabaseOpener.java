package com.cell2iwebservice.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import com.cell2iwebservice.utilities.Shadow;

public class DatabaseOpener {
	
	private static String makeConnectionString() {
		return "jdbc:oracle:thin:" + Shadow.getDBUsername() + "/" + Shadow.getDBPassword() + "@" +
							Shadow.getDBUrl() + ":" + Shadow.getDBPort() + ":" + Shadow.getDBName() ;
	}
	
	public static Connection open() {
		return open(Shadow.getDBUsername(), Shadow.getDBPassword(), Shadow.getDBName(), Shadow.getDBUrl());
	}
	
	public static Connection open(String DBUsername, String DBPassword) {
		return open(DBUsername, DBPassword, Shadow.getDBUrl(), Shadow.getDBName());
	}
	
	public static Connection open(String DBUsername, String DBPassword, String DBName) {
		return open(Shadow.getDBUsername(), DBPassword, DBName, Shadow.getDBUrl());
	}
	
	public static Connection open(String DBUsername, String DBPassword, String DBName, String DBUrl) {
		Connection con = null;
		try {
			Class.forName(Shadow.getDBDriver()).newInstance();
			con = DriverManager.getConnection( makeConnectionString() , DBUsername, DBPassword);
		} catch(Exception e) {
			System.out.println("Database Connection Error!\n" + DBUrl + " "+ DBName + "\n" + e);
		}        
		return con;
	}
}