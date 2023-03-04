package com.service;

import java.util.List;

import com.dao.AdminDao;
import com.entity.Admin;

public class AdminService {
	AdminDao ad = new AdminDao();
	
	public List<Admin> findAllAdmins(){
		return ad.listAllAdmins();
	}
}
