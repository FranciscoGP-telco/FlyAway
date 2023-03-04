package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Flight;
import com.resource.DbResource;

public class FlightDao {
	TypedQuery tq = null;
	public List<Flight> listFilterFlights(String source, String destiny, int numPassengers, String formatedDate){
		Session ss = DbResource.getSession();
		List<Flight> listFilterFlights = null;
		try {
			tq = ss.createQuery("SELECT f FROM flights f "
					+ "WHERE f.source LIKE :source "
					+ "AND f.destiny LIKE :destiny "
					+ "AND f.n_passengers = ;n_passengers "
					+ "AND f.flight_date = :flight_date")
					.setParameter("source", source)
					.setParameter("destiny", destiny)
					.setParameter("n_passengers", numPassengers)
					.setParameter("flight_date", formatedDate);
			listFilterFlights = tq.getResultList();
		} catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		} finally  {
			ss.close();
		}
		
		return listFilterFlights;
	}
	
	public List<Flight> listAllFlights(){
		Session ss = DbResource.getSession();
		List<Flight> listAllFlights = null;
		try{
			TypedQuery tq = ss.createQuery("FROM Flight");
			listAllFlights = tq.getResultList();
		}  catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		} finally  {
			ss.close();
		}
		return listAllFlights;
	}

}

