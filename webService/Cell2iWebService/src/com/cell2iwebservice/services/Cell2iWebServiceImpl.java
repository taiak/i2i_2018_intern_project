package com.cell2iwebservice.services;

import com.cell2iwebservice.dao.User;
import com.cell2iwebservice.dao.Invoice;
import com.cell2iwebservice.dao.Tariff;
import com.cell2iwebservice.utilities.SafeLogin;

/********************************
 * 
 * @author : taha yasir kiroglu
 * @date   : 10.07.2018
 * 
 *********************************/


public class Cell2iWebServiceImpl {
	
	public Cell2iWebServiceImpl() { 
	}	

	// control is username and user password valid?
	public boolean isAuthorized(String userId, String password) {
		//return (userId.equals(password));
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
	
	public String getUserInfo(String userId) {
		return User.getUserInfo(userId);
	}
	
	public String getTariffInfo(String userId) {
		return Tariff.getTariffInfo(userId);
	}
	
	public String getInvoiceInfo(String userId, int invoiceCount) {
		return Invoice.getInvoiceInfo(userId, invoiceCount);
	}

	public String getUsageInfo(String userId, String infoType) {
		return User.getUsageInfo(userId, infoType);
	}
}
