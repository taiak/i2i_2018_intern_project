package com.cell2iwebservice.dao;

public class User extends DAO {
	
	/*  Return login statement
	 * @post 
	 * 		CELL2I.CELL2I_UTILITY.login return 0 => false
	 * 									return 1 => true
	 */
	public static boolean isAuthorized(String userName, String password)
	{
		int connectionStatu = 0;
		boolean returnStatement = false;
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
		
		if (connectionStatu == 1) {
			returnStatement = true;
		} 
		else {
		    returnStatement = false;
		}
		
		return returnStatement;
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
	
}
