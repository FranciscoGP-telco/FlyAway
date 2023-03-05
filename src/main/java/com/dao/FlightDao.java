package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Flight;
import com.resource.DbResource;

public class FlightDao {
	TypedQuery tq = null;
	public List<Flight> listFilterFlights(String source, String destiny){
		Session ss = DbResource.getSession();
		List<Flight> listFilterFlights = null;
		try {
			tq = ss.createQuery("FROM Flight f "
					+ "WHERE f.source LIKE :source "
					+ "AND f.destiny LIKE :destiny ")
					.setParameter("source", source)
					.setParameter("destiny", destiny);
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
	
	public Flight getFlightById(int flightId) {
		Session ss = DbResource.getSession();
		List<Flight> listAllFlights = null;
		Flight flight = null;
		try {
			TypedQuery tq = ss.createQuery("From Flight f "
					+ "WHERE f.flightId = :flightId")
					.setParameter("flightId", flightId);
			listAllFlights = tq.getResultList();
			flight = listAllFlights.get(0);
		}  catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		} finally  {
			ss.close();
		}
		return flight;
	}

}

