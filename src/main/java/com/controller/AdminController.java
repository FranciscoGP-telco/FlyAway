package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Admin;
import com.entity.Airline;
import com.entity.Flight;
import com.service.AdminService;
import com.service.AirlineService;
import com.service.FlightService;

@WebServlet("/Admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		AirlineService airlineService = new AirlineService();
		FlightService flightService = new FlightService();
		
		List<Airline> listOfAirlines = airlineService.findAllAirlines();
		List<Flight> listOfSources = flightService.findAllSources();
		List<Flight> listOfDestinies = flightService.findAllDestinies();
		List<Flight> listOfFlights = flightService.findAllFlights();
		
		request.setAttribute("listOfAirlines", listOfAirlines);
		request.setAttribute("listOfSources", listOfSources);
		request.setAttribute("listOfDestinies", listOfDestinies);
		request.setAttribute("listOfFlights", listOfFlights);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
