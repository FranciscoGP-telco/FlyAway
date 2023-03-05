package com.controller;

import java.io.IOException;
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
 * Servlet implementation class PurchaseController
 */
@WebServlet("/PurchaseController")
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		FlightService flightService = new FlightService();
		Flight flight = flightService.getFlightById(flightId);
		request.setAttribute("flight", flight);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Purchase.jsp");
		requestDispatcher.include(request, response);
	}

}
