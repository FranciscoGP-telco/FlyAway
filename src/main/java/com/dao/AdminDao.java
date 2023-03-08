package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Admin;
import com.resource.DbResource;

//Class with queries to the table admins
public class AdminDao {
	//Query to get the password of the specified id
	public String getPassword(String userName) {
		//Initialization of the List and the object
		List<Admin> listOfAdmin = null;
		Admin admin = null;
		//stablishing the session
		Session ss = DbResource.getSession();
		
		//Creation of the query
		TypedQuery tq = ss.createQuery("SELECT a FROM Admin a "
				+ "WHERE userName LIKE :userName")
				.setParameter("userName", userName);
		
		//Storing the results
		try{
			listOfAdmin = tq.getResultList();
			admin = listOfAdmin.get(0);
			
		} catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		}
		
		//Closing the session
		ss.close();
		//return of the result
		if(admin != null) {
			return admin.getPassword();
		} else {
			return "Incorrect user";
		}
		
				
	}
	
	//Query to change the Password
	public int changePassword(String adminName, String password) {
		//Initialization of the List
		int result = 0;
		
		//stablishing the session
		Session ss = DbResource.getSession();
		
		//Creation of the query
		Query query = ss.createQuery("UPDATE Admin SET password = :password WHERE userName LIKE :userName")
				.setParameter("userName", adminName)
				.setParameter("password", password);

		//Start the transaction
		Transaction tr = ss.beginTransaction();
		try {
			//Executing the query
			result = query.executeUpdate();
			tr.commit();
		} catch (Exception e) {
			//If we have some problem, we perform a rollback
			System.out.println("Error " + e.toString() + " changing the password");
			tr.rollback();
		}
		//Closing the session
		ss.close();
		return result;
	}
	
}
