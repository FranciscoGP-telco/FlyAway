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
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		FlightService fs = new FlightService();
		List<Flight> listOfFlights = fs.findAllFlights();
		request.setAttribute("listOfFlights", listOfFlights);
		RequestDispatcher rd = request.getRequestDispatcher("ListFlights.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		//flightdate source destiny number
		
		String source = request.getParameter("source");
		String destiny = request.getParameter("destiny");
		int numPassengers = Integer.parseInt(request.getParameter("number"));
		Date date = new Date(request.getParameter("flightdate"));
		FlightService fs = new FlightService();
		List<Flight> listOfFlights = fs.findFlights(source, destiny, numPassengers, date);
		request.setAttribute("listOfFlights", listOfFlights);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

}
