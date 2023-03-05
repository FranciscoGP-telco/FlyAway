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

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/FlightController")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FlightController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		FlightService flightService = new FlightService();
		List<Flight> listOfFlights = flightService.findAllFlights();
		request.setAttribute("listOfFlights", listOfFlights);
		RequestDispatcher rd = request.getRequestDispatcher("/ListFlights.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String source = request.getParameter("source");
		String destiny = request.getParameter("destiny");
		FlightService flightService = new FlightService();
		List<Flight> listOfFlights = flightService.findFlights(source, destiny);
		request.setAttribute("listOfFlights", listOfFlights);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
		requestDispatcher.include(request, response);
	}

}
