package com.cell2iwebservice.dao;

import java.sql.SQLException;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class Tariff extends DAO {

	// tarifid_name
	
	public static String getTariffInfo(String msisdn) {
		String resultString = "";
		String userInfoSql = "{ ? = call CELL2I.CELL2I_UTILITY.get_tariffinfo(?) }";
		try {
			connectionOpen();
			callableStatement = sqlConnection.prepareCall(userInfoSql);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.setString(2, msisdn);
			callableStatement.execute();
			
			resultSet =((OracleCallableStatement) callableStatement).getCursor(1);
			
			if (resultSet.next()){
				resultString += resultSet.getString(1) + seperator+
								resultSet.getString(2) + seperator +
								resultSet.getString(3) + seperator +
								resultSet.getString(4);
			}
			
			connectionClose();
		} catch (SQLException e) {
			System.out.println(e);
			resultString = "error";
		}
		
		return resultString;
	}
	
}
