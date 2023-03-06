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
import com.entity.Purchase;
import com.service.FlightService;
import com.service.PurchaseService;


@WebServlet("/Finish")
public class FinishController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FinishController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creation of the session and stablishing the content type of the response
		HttpSession session = request.getSession(); 
		response.setContentType("text/html");
		
		//Creation of the flight object
		FlightService flightService = new FlightService();
		Flight flight = flightService.getFlightById((Integer)session.getAttribute("flightId"));

		//Cration or purchase object and inserting all the attributes from the session
		Purchase purchase = new Purchase();
		purchase.setName(session.getAttribute("name").toString());
		purchase.setlastName(session.getAttribute("lastName").toString());
		purchase.setEmail(session.getAttribute("email").toString());
		purchase.settlfnNumber((Integer)session.getAttribute("tlfnNumber"));
		purchase.setCardNumber(session.getAttribute("tlfnNumber").toString());
		purchase.setNumPassengers((Integer)session.getAttribute("passengersNumber"));
		purchase.setFlight(flight);
		
		//Creation of purchaseService Object and sending the object to store it in the DB
		PurchaseService purchaseService = new PurchaseService();
		String result = purchaseService.savePurchase(purchase);
		
		//Saving the result in the session
		session.setAttribute("result", result);
		
		//RequestDispatcher to send the info to the jsp file
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Finish.jsp");
		requestDispatcher.include(request, response);
	}

}
