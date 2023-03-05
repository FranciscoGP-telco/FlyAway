package com.service;

import java.util.List;

import com.dao.FlightDao;
import com.entity.Flight;

public final class FlightService {
	FlightDao fd = new FlightDao();
	
	public List<Flight> findAllFlights(){
		return fd.listAllFlights();
	}
	
	public List<Flight> findFlights(String source, String destiny){
		List<Flight> listOfFlights = fd.listFilterFlights(source, destiny);
		return listOfFlights;
	}
	
	public Flight getFlightById(int flightId) {
		return fd.getFlightById(flightId);
	}
	
}
