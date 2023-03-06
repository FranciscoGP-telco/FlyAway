package com.service;

import java.util.List;

import com.dao.AirlineDao;
import com.entity.Airline;

public class AirlineService {
	AirlineDao ad = new AirlineDao();
	
	//Function to call the query listAllAirlines 
	public List<Airline> findAllAirlines(){
		return ad.listAllAirlines();
	}
}
