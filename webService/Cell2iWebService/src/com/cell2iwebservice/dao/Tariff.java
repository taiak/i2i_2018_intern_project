package com.cell2iwebservice.dao;

public class Tariff extends DAO {
	/*  Return tariff id by name
	 * @post 
	 * 		CELL2I.CELL2I_UTILITY.get_tariff_id_byname 
	 * 											  return > 1 => tariffNumber
	 * 											  return = 0 => error
	 */
	public static int get_tariff_id_byname(String tariffName)
	{
		int tariffNumber = 0;
		try {
			connectionOpen();
			String sql = "{ ? = call CELL2I.CELL2I_UTILITY.get_tariff_byname(?) }";
			callableStatement = sqlConnection.prepareCall(sql);
			callableStatement.setString(2, tariffName);
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);  
	
			callableStatement.execute();
			tariffNumber = callableStatement.getInt(1);
			connectionClose();
		}catch(Exception e)	{
			tariffNumber = 0;
			System.out.println("Error: in get_tariff_id_byname()");
			System.out.println(e);
		}

		return tariffNumber;
	}
	
	/*  Return tariff id by sub msisdn
	 * @post 
	 * 		CELL2I.CELL2I_UTILITY.get_tariff_id_bysubmsisdn(
	 * 											  return > 1 => tariffNumber
	 * 											  return = 0 => error and 0
	 */
	public static int get_tariff_id_bysubmsisdn(String msisdn)
	{
		int tariffNumber = 0;
		try {
			connectionOpen();
			String sql = "{ ? = call CELL2I.CELL2I_UTILITY.get_tariff_id_bysubmsisdn(?) }";
			callableStatement = sqlConnection.prepareCall(sql);
			callableStatement.setString(2, msisdn);
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);  
	
			callableStatement.execute();
			tariffNumber = callableStatement.getInt(1);
			connectionClose();
		}catch(Exception e)	{
			tariffNumber = 0;
			System.out.println("Error: in get_tariff_id_bysubmsisdn()");
			System.out.println(e);
		}

		return tariffNumber;
	}
	
	
	// TODO: learn how cursor work
	
	/*  
		table get_tariffinfo(String msisdn)
	*/
}
