package com.cell2iwebservice.services;

public class LoginControl {
    private String userName;
    
    public LoginControl(){
    	this.userName = "cell2i";
    }
    
    public LoginControl(String userName){
    	this.userName = userName;
    }
    
    public String getName() {
        return userName;
    }
    
    public void setName(String userName) {
        this.userName = userName;
    }
}
