package com.cell2iwebservice.services;

/********************************
 * 
 * @author : taha yasir kiroglu
 * @date   : 07.07.2018
 * 
 * 
 ********************************/

/* NOTE: change package name before you compile */

public class Cell2iWebServiceImpl {
	
	// values for login examples
	private static String _userName;
	private static String _userPassword;
	
	public Cell2iWebServiceImpl() {
		setLoginExample();
    }
	
	
	/* _userName and _userPassword must have value
	 * @post _userName = static_value; _userPassword = value;
	 */
	// add login example till database
	private void setLoginExample() {
        _userName     = "cell2i";
        _userPassword = "cell3i";
    }
	
	/*
	 *  name and password must smaller than 60 character
	 *  @pre  name.count() < 60 && password < 60
	 *  
	 *  username and password must be valid
	 *  @post _username == name && _userpassword == password
	 */
	 // control is username and user password valid?
	public boolean isAuthorized(String name, String password) {
		return ( _userName.equals(name) && _userPassword.equals(password) ) ? true: false;
	}
	
	/*
	 * @post return of isConnected is "Connect Successful"
	 */
	// control statu
	public String isConnected() {
		return "Connect Successful";
	}
	
}
