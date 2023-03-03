package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Flight;
import com.resource.DbResource;

public class FlightDao {
	
	public List<Flight> listFilterFlights(String source, String destiny, int numPassengers, String formatedDate){
		SessionFactory sf = DbResource.getSessionFactory();
		Session ss = sf.openSession();
		TypedQuery tq = ss.createQuery("SELECT f FROM flights f "
				+ "WHERE f.source LIKE :source "
				+ "AND f.destiny LIKE :destiny "
				+ "AND f.n_passengers = ;n_passengers "
				+ "AND f.flight_date = :flight_date")
				.setParameter("source", source)
				.setParameter("destiny", destiny)
				.setParameter("n_passengers", numPassengers)
				.setParameter("flight_date", formatedDate);
		List<Flight> listFilterFlights = tq.getResultList();
		return listFilterFlights;
	}
	
	public List<Flight> listAllFlights(){
		SessionFactory sf = DbResource.getSessionFactory();
		Session ss = sf.openSession();
		TypedQuery tq = ss.createQuery("FROM flights");
		List<Flight> listAllFlights = tq.getResultList();
		return listAllFlights;
	}

}

