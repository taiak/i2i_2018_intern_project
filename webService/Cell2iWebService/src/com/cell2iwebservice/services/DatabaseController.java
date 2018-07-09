package com.cell2iwebservice.services;

import java.sql.Connection;

import com.cell2iwebservice.utilities.DatabaseOpener;

public class DatabaseController {
	private static String DB_Driver   = "oracle.jdbc.driver.OracleDriver";	
	
	// böl, parçala, yönet
	// sadece kod çalýþtýrýldý
	// kodun içi incelendi. Refoactoringe ihtiyaç var
	// XXX: saat 03.00 civarý. javamana dönüþmenin lüzumu yok
	public static String connect_test() {

	    System.out.println("-------- Oracle JDBC Connection Testing ------");

	    try {
	    	
	        Class.forName(DB_Driver);

	    } catch (ClassNotFoundException e) {
	    
	           System.out.println("Warning: Oracle JDBC Driver mot found!");
	          
	           e.printStackTrace();
	           
	           return "Class Not Found Exception";
	    }

	    System.out.println("Oracle JDBC Driver Registered!");

	    Connection connection = null;

	    try {

	        connection = DatabaseOpener.open();
	    } catch (Exception e) {
	        	
	        System.out.println("Connection Failed! Check output console");
	        e.printStackTrace();
	        
	        return "Connection Failed!";

	    }

	    if (connection == null) {	
	        System.out.println("Failed to make connection!");
	        return "Failed to make connection";
	    }	        
	        
	    System.out.println("You made it, take control your database now!");
	        

	    return "Connection Succesful";
	    
	}

		
}
