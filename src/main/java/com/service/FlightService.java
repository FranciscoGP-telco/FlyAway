package com.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dao.FlightDao;
import com.entity.Flight;

public final class FlightService {
	FlightDao fd = new FlightDao();
	
	public List<Flight> findAllFlights(){
		return fd.listAllFlights();
	}
	
	public List<Flight> findFlights(String source, String destiny, int numPassengers, Date date){
		List<Flight> listOfFlights = fd.listFilterFlights(source, destiny, numPassengers, formatDateToMysql(date));
		return listOfFlights;
	}
	
	private String formatDateToMysql(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date).toString();
	}
}
