package com.service;

import java.util.List;

import com.dao.AirlineDao;
import com.entity.Airline;

public class AirlineService {
	AirlineDao ad = new AirlineDao();
	
	public List<Airline> findAllAirlines(){
		return ad.listAllAirlines();
	}
}
