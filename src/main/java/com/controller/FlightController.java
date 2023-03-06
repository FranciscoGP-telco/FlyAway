package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Flight;
import com.service.FlightService;


@WebServlet("/Flights")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FlightController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Stablishing the content type of the response
		response.setContentType("text/html");
		
		//Creation of a FlightService object and a List of Flights from the query
		FlightService flightService = new FlightService();
		List<Flight> listOfFlights = flightService.findAllFlights();
		
		//Saving as an attritubte the List and sending to the request
		request.setAttribute("listOfFlights", listOfFlights);
		RequestDispatcher rd = request.getRequestDispatcher("/ListFlights.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Stablishing the content type of the response
		response.setContentType("text/html");
		
		//Getting the parameters from the form
		String source = request.getParameter("source");
		String destiny = request.getParameter("destiny");
		
		//Creation of a FlightService object and a List of Flights from the query, filtering by the source and destniy
		FlightService flightService = new FlightService();
		List<Flight> listOfFlights = flightService.findFlights(source, destiny);
		
		//Saving as an attritubte the List and sending to the request
		request.setAttribute("listOfFlights", listOfFlights);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
		requestDispatcher.include(request, response);
	}

}
