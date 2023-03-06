package com.service;

import java.util.List;

import com.dao.AdminDao;
import com.entity.Admin;

public class AdminService {
	AdminDao ad = new AdminDao();
	
	//Function to call the getPassword query
	public String getPassword(String adminName){
		return ad.getPassword(adminName);
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

