package com.cell2iwebservice.utilities;

public class Shadow {
	private static String DBUsername = "cell2i";
	private static String DBPassword = "cell2iapp";
	private static String DBName     = "xe";
	private static String DBUrl      = "209.97.129.103";
	private static String DBPort     = "1521";	
	private static String DBDriver   = "oracle.jdbc.driver.OracleDriver";
	
	public static String getDBUsername() {
		return DBUsername;
	}
	
	public static String getDBPassword() {
		return DBPassword;
	}
	
	public static String getDBName() {
		return DBName;
	}
	
	public static String getDBUrl() {
		return DBUrl;
	}
	
	public static String getDBPort() {
		return DBPort;
	}
	
	public static String getDBDriver() {
		return DBDriver;
	}
	
	
	
}
