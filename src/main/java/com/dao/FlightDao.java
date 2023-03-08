package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Flight;
import com.resource.DbResource;

//Class with queries to the table flights
public class FlightDao {
	
	//Query to get all the flights with the filters in the parameters
	public List<Flight> listFilterFlights(String source, String destiny){
		//Initialization of the List
		List<Flight> listFilterFlights = null;
		
		//stablishing the session
		Session ss = DbResource.getSession();
		
		//Creation of the query
		TypedQuery tq = ss.createQuery("FROM Flight f "
				+ "WHERE f.source LIKE :source "
				+ "AND f.destiny LIKE :destiny ")
				.setParameter("source", source)
				.setParameter("destiny", destiny);
		//Executing the query and Storing the results
		try {

			listFilterFlights = tq.getResultList();
		} catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		}
		
		ss.close();
		return listFilterFlights;
	}
	
	//Query to get all the flights
	public List<Flight> listAllFlights(){
		//Initialization of the List
		List<Flight> listAllFlights = null;
		
		//stablishing the session
		Session ss = DbResource.getSession();
		
		//Creation of the query
		TypedQuery tq = ss.createQuery("FROM Flight");
		//Executing the query and Storing the results
		try{
			listAllFlights = tq.getResultList();
		}  catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		}
		ss.close();
		return listAllFlights;
	}
	
	//Query to get all the sources
	public List<String> listAllSources(){
		//Initialization of the List
		List<String> sourceList = null;
		
		//stablishing the session
		Session ss = DbResource.getSession();
		
		//Creation of the query
		TypedQuery tq = ss.createQuery("SELECT DISTINCT f.source FROM Flight f");
		//Executing the query and Storing the results
		try{
			sourceList = tq.getResultList();
		}  catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		}
		ss.close();
		return sourceList;
	}
	
	//Query to get all the destinies
	public List<String> listAllDestinies(){
		//Initialization of the List
		List<String> destinyList = null;
		
		//stablishing the session
		Session ss = DbResource.getSession();
		
		//Creation of the query
		TypedQuery tq = ss.createQuery("SELECT DISTINCT f.destiny FROM Flight f");
		//Executing the query and Storing the results
		try{
			destinyList = tq.getResultList();
		}  catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		}
		//Closing the session
		ss.close();
		return destinyList;
	}
	
	//Query to get a flight by the id
	public Flight getFlightById(int flightId) {
		//Initialization of the List and the object
		List<Flight> listAllFlights = null;
		Flight flight = null;

		//stablishing the session
		Session ss = DbResource.getSession();
		
		//Creation of the query
		TypedQuery tq = ss.createQuery("From Flight f "
				+ "WHERE f.flightId = :flightId")
				.setParameter("flightId", flightId);
		//Executing the query and Storing the results
		try {
			listAllFlights = tq.getResultList();
			//getting the first result
			flight = listAllFlights.get(0);
		}  catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		}
		//Closing the session
		ss.close();
		return flight;
	}

}

