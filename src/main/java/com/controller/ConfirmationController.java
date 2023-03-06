package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Flight;
import com.service.FlightService;


@WebServlet("/Confirmation")
public class ConfirmationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConfirmationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creation of the session and stablishing the content type of the response
		HttpSession session = request.getSession();  
		response.setContentType("text/html");
		
		//reading the parameters from the post request
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		int tlfnNumber = Integer.parseInt(request.getParameter("tlfnNumber"));
		int passengersNumber = Integer.parseInt(request.getParameter("passengersNumber"));
		String email = request.getParameter("email");
		
		//Creation of the flight object
		FlightService flightService = new FlightService();
		Flight flight = flightService.getFlightById(flightId);

		//Settings the attributes of the http session
		session.setAttribute("name",name);
		session.setAttribute("lastName",lastName);
		session.setAttribute("tlfnNumber",tlfnNumber);
		session.setAttribute("email",email);
		session.setAttribute("passengersNumber", passengersNumber);
		session.setAttribute("flightDestination", flight.getDestiny());
		session.setAttribute("flightSource", flight.getSource());
		session.setAttribute("flightPrice", flight.getPrice());
		session.setAttribute("flightDate", flight.getFlightDate());
		session.setAttribute("flightId", flightId);
		
		//RequestDispatcher to send the info to the jsp file
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Payment.jsp");
		requestDispatcher.include(request, response);
	}

}
