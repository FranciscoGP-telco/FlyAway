package com.resource;
import javax.inject.Singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//Using the Singleton patron to ensure that we will have only one session
@Singleton
public class DbResource {
	private static SessionFactory factory;
	public static Session getSession() {
		//If we don't have a factory create, we create a new one
		if (factory == null) {
			//Stablishing the configuration of the file hibernate.cfg.xml and building the factory
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			factory = con.buildSessionFactory();
		}
		
		return factory.openSession();
	}
	
}
