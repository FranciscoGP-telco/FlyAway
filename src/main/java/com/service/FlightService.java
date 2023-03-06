package com.service;

import java.util.List;

import com.dao.FlightDao;
import com.entity.Flight;

public final class FlightService {
	FlightDao fd = new FlightDao();
	
	//Function to call the query listAllFlights
	public List<Flight> findAllFlights(){
		return fd.listAllFlights();
	}
	
	//Function to call the query listAllSources
	public List<Flight> findAllSources(){
		return fd.listAllSources();
	}
	
	//Function to call the query listAllDestinies
	public List<Flight> findAllDestinies(){
		return fd.listAllDestinies();
	}
	
	//Function to call the query listFilterFlights
	public List<Flight> findFlights(String source, String destiny){
		List<Flight> listOfFlights = fd.listFilterFlights(source, destiny);
		return listOfFlights;
	}
	
	//Function to call the query getFlightById
	public Flight getFlightById(int flightId) {
		return fd.getFlightById(flightId);
	}
	
}
