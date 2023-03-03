package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Admin;
import com.resource.DbResource;

public class AdminDao {
	public String getPassword(String adminId) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session ss = sf.openSession();
		TypedQuery tq = ss.createQuery("SELECT a.password FROM admin a "
				+ "WHERE admin_id LIKE :admin_id")
				.setParameter("admin_id", adminId);
		List<Admin> listOfAdmin = tq.getResultList();
		return listOfAdmin.get(0).getPassword();
	}
	
	public int changePassword(String userName, String password) {
		int result = 0;
		SessionFactory sf = DbResource.getSessionFactory();
		Session ss = sf.openSession();
		Query query = ss.createQuery("UPDATE admins SET password = :password WHERE username LIKE :username")
				.setParameter("username", userName)
				.setParameter("password", password);
		Transaction tr = ss.beginTransaction();
		try {
			result = query.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error " + e.toString() + " changing the password");
			tr.rollback();
		}
		return result;
	}
}
