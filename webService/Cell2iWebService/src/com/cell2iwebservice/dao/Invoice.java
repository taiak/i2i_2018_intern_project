package com.cell2iwebservice.dao;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class Invoice extends DAO {
	
	//TODO: learn how cursor return value
	/*	
		date get_startdayfrominvoice (String msisdn)
	*/
	
	public static String getInvoiceInfo(String msisdn, int invoiceCount) {
		// List<String> invoices = new ArrayList<String>();
		
		String resultString = "";
		String userInfoSql = "{ ? = call CELL2I.CELL2I_UTILITY.get_invoiceInfo(?) }";
		try {
			connectionOpen();
			callableStatement = sqlConnection.prepareCall(userInfoSql);
			callableStatement.registerOutParameter(1,OracleTypes.CURSOR);
			callableStatement.setString(2, msisdn);
			callableStatement.execute();
			
			resultSet =((OracleCallableStatement) callableStatement).getCursor(1);
			for (int i = 0 ;resultSet.next() && i < invoiceCount;resultString += lineSeperator){
				resultString +=  resultSet.getString(1) + seperator +
								 resultSet.getString(2) + seperator +
								 resultSet.getString(3) + seperator +
								 resultSet.getString(4);
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
