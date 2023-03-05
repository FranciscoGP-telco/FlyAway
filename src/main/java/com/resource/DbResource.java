package com.resource;
import javax.inject.Singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Singleton
public class DbResource {
	private static SessionFactory factory;
	public static Session getSession() {
		if (factory == null) {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			factory = con.buildSessionFactory();		
		}
		
		return factory.openSession();
	}
	
	public static void close() {
		factory.close();
	}
	
}
