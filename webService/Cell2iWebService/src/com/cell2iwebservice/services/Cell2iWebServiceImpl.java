package com.cell2iwebservice.services;

import com.cell2iwebservice.dao.User;
import com.cell2iwebservice.dao.Tariff;
import com.cell2iwebservice.utilities.SafeLogin;

/**********************
 * 
 * @author : taha yasir kiroglu
 * @date   : 04.07.2018
 */


public class Cell2iWebServiceImpl {


	public Cell2iWebServiceImpl() {
		
    }

	// control is username and user password valid?
	public boolean isAuthorized(String userId, String password) {
		return User.isAuthorized(userId, SafeLogin.getSha256(password));
	}
	
	// control statu
	public String isConnected() {
		return "Connect Successful";
	}
	
	public String isDBConnected() {
		return DatabaseController.connect_test();
	}
	
	public boolean changeUserPassword(String userId, String password) {
		return User.changePassword(userId, SafeLogin.getSha256(password));		
	}
	
	public int getTariffIdByname(String tariffName) {
		return Tariff.get_tariff_id_byname(tariffName);
	}
	
	public int getTariffIdBySubmsisdn(String msisdn) {
		return Tariff.get_tariff_id_bysubmsisdn(msisdn);
	}
}
