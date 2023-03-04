package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Airline;
import com.resource.DbResource;

public class AirlineDao {
	public List<Airline> listAllAirlines(){
		List<Airline> listOfAllAirlines = null;
		Session ss = DbResource.getSession();
		//TypedQuery tq = ss.createQuery("from Airline");
		TypedQuery tq = ss.createQuery("Select a from Airline a");
		try{
			listOfAllAirlines = tq.getResultList();
		}  catch (Exception e) {
			System.out.println("Error " + e.toString() + "executing the query");
		} finally  {
			ss.close();
		}
		return listOfAllAirlines;
	}
}
