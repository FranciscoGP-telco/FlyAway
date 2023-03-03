package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Purchase;
import com.resource.DbResource;

public class PurchaseDao {
	
	public boolean storePurchase(Purchase purchase) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.getTransaction();
		tr.begin();
		try {
			ss.save(purchase);
		} catch (Exception e) {
			System.out.println("Error " + e.toString() + " processing the purchase");
			tr.rollback();
			return false;
		}
		tr.commit();
		return true;
	}
}
