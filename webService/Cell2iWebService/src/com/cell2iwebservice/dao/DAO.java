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
import java.util.List;

import com.cell2iwebservice.utilities.DatabaseOpener;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class DAO {
	protected static PreparedStatement preparedStatement = null;
	protected static ResultSet resultSet = null;
	protected static Connection sqlConnection = null;
	protected static CallableStatement callableStatement = null;
	protected static String seperator = "_";
	protected static String lineSeperator = "@@";
	protected static String packageName = "CELL2I.CELL2I_UTILITY";
	public static List<String> sqlFunctionParameters = null;
	
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
	
	// NOT: sql injection saldýrýsýna karþý dýþarý açýlmamalýdýr!
	public static String getFunctionInfo(String functionName, List<String> sqlFunctionParameters, int parameterCount  ) {
		String resultString = "";
		int parameterLength = 0;
		String infoSql = "";
		
		// set parameter string
		try {
			parameterLength = sqlFunctionParameters.size();
			infoSql = "{ ? = call " + packageName + "." + functionName + "(?";
	
			for(int i = 1; i < parameterLength; i++) {
				infoSql += ",?";
			}
			infoSql += ") }";
		
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		System.out.println("infoSql : " + infoSql);
		// connect and make connection
		try {
			connectionOpen();
			callableStatement = sqlConnection.prepareCall(infoSql);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			System.out.println("Hata yok!");
			
			// wtf?
			for(int seq = 1; seq <= parameterLength; seq++) {
				System.out.println(Integer.toString(seq) + sqlFunctionParameters.get(seq) );
				callableStatement.setString(seq, sqlFunctionParameters.get(seq));
			}
			
			System.out.println("döngðden sonra");
			
			callableStatement.execute();
			resultSet =((OracleCallableStatement) callableStatement).getCursor(1);
			System.out.println("resultset ayarlandý");
			if(resultSet.next()){
				for(int i = 1; i < parameterCount; i++, resultString += seperator) {
					resultString += resultSet.getString(i);
				}
				System.out.println("Bum");
			}
			
			connectionClose();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return resultString;
	}
	
}
