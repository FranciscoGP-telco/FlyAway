package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Airline;
import com.resource.DbResource;

//Class with queries to the table airlines
public class AirlineDao {
	
	//Query to get all the airlines
	public List<Airline> listAllAirlines(){
		//Initialization of the List
		List<Airline> listOfAllAirlines = null;
		
		//stablishing the session
		Session ss = DbResource.getSession();
		
		//Creation of the query
		TypedQuery tq = ss.createQuery("Select a from Airline a");
		
		//Storing the results
		try{
			listOfAllAirlines = tq.getResultList();
		}  catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		} finally  {
			//Closing the session
			ss.close();
		}
		return listOfAllAirlines;
	}
}
