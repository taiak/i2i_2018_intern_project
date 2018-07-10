package com.cell2iwebservice.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
/*
 *    Taha Yasir Kýroðlu
 * 
 *    06.07.2018 
 *    This Dao class created because of sql connection
 * 
 * 
 * */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cell2iwebservice.utilities.DatabaseOpener;

public class DAO {
	protected static PreparedStatement preparedStatement = null;
	protected static ResultSet resultSet = null;
	protected static Connection sqlConnection = null;
	protected static CallableStatement callableStatement = null;
	
	public static void connectionOpen()throws SQLException{
		sqlConnection = DatabaseOpener.open();
	}
	
	
	// close all  crs, ps,con
	public static void connectionClose() throws SQLException{
	    try { 
	    	resultSet.close();
	    	System.out.println("DB: resultSet successfully closed");
	    } catch (Exception e) { 
	    	System.out.println("Warning: resultSet closing unsuccessfull!!!"); 
	    }
	    
	    try { 
	    	preparedStatement.close();
	    	System.out.println("DB: preparedStatement successfully closed.");
	    } catch (Exception e)  { 
	    	System.out.println("Warning: preparedStatement closing unsuccessfull!!!"); 
	    }
	    
	    sqlConnection.close();
	    System.out.println("DB: Connection successfully closed.");
	}	
	
}
