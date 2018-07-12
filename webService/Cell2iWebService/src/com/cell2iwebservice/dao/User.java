package com.cell2iwebservice.dao;

import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class User extends DAO {
	
	/*  Return login statement
	 * @post 
	 * 		CELL2I.CELL2I_UTILITY.login return 0 => false
	 * 									return 1 => true
	 */
	public static boolean isAuthorized(String userName, String password)
	{
		int connectionStatu = 0;
		try {
			connectionOpen();
			String sql = "{ ? = call CELL2I.CELL2I_UTILITY.check_user_is_valid(?,?) }";
			callableStatement = sqlConnection.prepareCall(sql);
			callableStatement.setString(2, userName);
			callableStatement.setString(3, password);
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);  
			callableStatement.execute();
			
			connectionStatu = callableStatement.getInt(1);
			connectionClose();
		}
		catch (Exception e) {
			System.out.println("Error: in isAuthorized function:");
			System.out.println(e);
			connectionStatu = 0;
		}
		
		return (connectionStatu == 1);
	}
	
	/*  Return password change statement
	 * @post 
	 * 		CELL2I.CELL2I_UTILITY.change_password return 0 => false
	 * 											  return 1 => true
	 */
	public static boolean changePassword(String userId, String password){
		int passwordChangeStatu = 0;
		boolean returnStatement = false;
		
		try {
			connectionOpen();
			String sql = "{ ? = call CELL2I.CELL2I_UTILITY.change_password(?,?) }";
			callableStatement = sqlConnection.prepareCall(sql);
			callableStatement.setString(2, userId);
			callableStatement.setString(3, password);
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);  
	
			callableStatement.execute();
			
			passwordChangeStatu = callableStatement.getInt(1);
			connectionClose();
		}catch(Exception e) {
			System.out.println("Error: in isAuthorized function:");
			System.out.println(e);
			passwordChangeStatu = 0;
		}
		
		if (passwordChangeStatu == 0) {
			returnStatement = false;
		} 
		else if (passwordChangeStatu == 1) {
		    returnStatement = true;
		}
		
		return returnStatement;
	}
	
	
	public static String getUserInfo(String msisdn) {
		String resultString = "";
		String userInfoSql = "{ ? = call CELL2I.CELL2I_UTILITY.get_subscriberinfo(?) }";
		try {
			connectionOpen();
			callableStatement = sqlConnection.prepareCall(userInfoSql);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.setString(2, msisdn);
			callableStatement.execute();
			
			resultSet =((OracleCallableStatement) callableStatement).getCursor(1);
			System.out.println("resultSet");
			
			if (resultSet.next()){
				resultString += resultSet.getString(1) + seperator +
								resultSet.getString(2) + seperator +
								resultSet.getString(3);
			}
			
			connectionClose();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return resultString;
	}

	// XXX: exception yönetimi yapýlmadý
 
	
	public static String getUsageInfo(String msisdn, String usageType) {
		// List<String> invoices = new ArrayList<String>();
		
		String resultString = "";
		String userInfoSql = "{ ? = call CELL2I.CELL2I_UTILITY.get_usageInfo(?,?) }";
		try {
			connectionOpen();
			callableStatement = sqlConnection.prepareCall(userInfoSql);
			callableStatement.registerOutParameter(1,OracleTypes.CURSOR);
			callableStatement.setString(2, msisdn);
			callableStatement.setString(3, usageType);
			callableStatement.execute();
			
			resultSet =((OracleCallableStatement) callableStatement).getCursor(1);
			if (resultSet.next()){
				resultString +=  resultSet.getString(1) + seperator +
								 resultSet.getString(2) + seperator +
								 resultSet.getString(3);
				
				System.out.println(resultString);
			}
			connectionClose();
		} catch (Exception e) {
			System.out.println(e);
			resultString = "error";
		}
		
		return resultString;
	}	
}
