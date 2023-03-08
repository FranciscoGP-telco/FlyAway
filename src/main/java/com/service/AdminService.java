package com.service;

import com.dao.AdminDao;

public class AdminService {
	AdminDao ad = new AdminDao();
	
	//Function to call the getPassword query
	public String getPassword(String adminName){
		return ad.getPassword(adminName);
	}
	
	//Function to check if the password is correct
	public boolean authentication(String adminName, String insertedPassword) {
		String dbPassword = getPassword(adminName);
		return dbPassword.equals(insertedPassword);
	}
	
	//Function to call the changePassword query. Checks the results and return a String
	public String changePassword(String username, String password) {
		if(ad.changePassword(username, password) == 1) {
			return "Password changed correctly";
		} else {
			return "Problem changing the password";
		}
	}
}

