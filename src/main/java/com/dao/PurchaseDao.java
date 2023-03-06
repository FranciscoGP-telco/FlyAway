package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Purchase;
import com.resource.DbResource;

//Class with queries to the table purchases
public class PurchaseDao {
	
	//Query to store the purchase
	public boolean storePurchase(Purchase purchase) {
		//stablishing the session
		Session ss = DbResource.getSession();
		//Start the transaction
		Transaction tr = ss.beginTransaction();
		tr.begin();
		//executing the query
		try {
			ss.save(purchase);
		} catch (Exception e) {
			//If we have some problem, we perform a rollback
			System.out.println("Error " + e.toString() + " processing the purchase");
			tr.rollback();
			return false;
		}
		//Closing the session
		tr.commit();
		return true;
	}
}
