package com.cell2iwebservice.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cell2iwebservice.utilities.DatabaseOpener;

public class DatabaseAccessor {

	public static PreparedStatement ps = null;
	public static Connection con = null;
	public static ResultSet rs = null;
	
	public static Connection connectionOpen() {
		System.out.println("DB_CONNECT: Database connection successfull!");
		return DatabaseOpener.open();
	}
	
	public static void connectionClose(ResultSet rs, PreparedStatement ps, Connection con) {
	    try { rs.close();  } catch (Exception e) { /* ignored */ }
	    try { ps.close();  } catch (Exception e) { /* ignored */ }
	    try { con.close(); } catch (Exception e) { /* ignored */ }
		System.out.println("DB_DISCONNECT: Database disconection successful!");
	}

	public static String executeFunction(String query) {
		String queryResult = "wööö";
		try {
			con = connectionOpen();
			ps = (PreparedStatement) con.prepareStatement(query);
			rs = ps.executeQuery();
			 while (rs.next()) {
				 queryResult = rs.getString(0);
				 System.out.println("0.index: " + rs.getString(0));
				 System.out.println("1.index: " + rs.getString(1));
			 }
		} catch (SQLException e) {
			System.out.println("DB: " + query + " error!");			
			System.out.println(e);
		} finally {
			connectionClose(rs, ps, con);
		}
		return queryResult;
	}
	
	

	public static boolean executeProcedure(String query) {
		boolean statu = false;

		try {
			con = connectionOpen();
			// = (PreparedStatement) con.prepareStatement(query);
			ps.executeUpdate();
			statu = true;
		} catch (Exception e) {
			System.out.println("DB: " + query + " error!");			
			System.out.println(e);
			
		} finally {
			connectionClose(rs, ps, con);
		}
		return statu;
	}

}