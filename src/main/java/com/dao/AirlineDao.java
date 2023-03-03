package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Airline;
import com.resource.DbResource;

public class AirlineDao {
	public List<Airline> listAllAirlines(){
		SessionFactory sf = DbResource.getSessionFactory();
		Session ss = sf.openSession();
		TypedQuery tq = ss.createQuery("from airlines");
		List<Airline> listOfAllAirlines = tq.getResultList();
		return listOfAllAirlines;
	}
}
