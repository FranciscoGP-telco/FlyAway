package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Airline;
import com.entity.Flight;
import com.service.AdminService;
import com.service.AirlineService;
import com.service.FlightService;

@WebServlet("/Admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminService();
   
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creation of the session and stablishing the content type of the response
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession httpSession = request.getSession();
		//As a default page, we stablish the login webpage
		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		//If is a new session, we send the user to the login Webpage
		if(httpSession.isNew()) {
			pw.println("You need to login to access this webpage");
		} else {
			String adminName = (String) httpSession.getAttribute("adminName");
			String password = (String) httpSession.getAttribute("password");
			if (adminService.authentication(adminName, password)){
				//Creation of the services
				AirlineService airlineService = new AirlineService();
				FlightService flightService = new FlightService();
				
				//Storing in list the queries
				List<Airline> listOfAirlines = airlineService.findAllAirlines();
				List<String> listOfSources = flightService.findAllSources();
				List<String> listOfDestinies = flightService.findAllDestinies();
				List<Flight> listOfFlights = flightService.findAllFlights();
				
				//Sending to the request as attributes
				request.setAttribute("listOfAirlines", listOfAirlines);
				request.setAttribute("listOfSources", listOfSources);
				request.setAttribute("listOfDestinies", listOfDestinies);
				request.setAttribute("listOfFlights", listOfFlights);
				
				//RequestDispatcher to send the info to the jsp file
				rd = request.getRequestDispatcher("/WEB-INF/Admin.jsp");
			} else {
				pw.println("Username and password incorrect!");
				rd = request.getRequestDispatcher("/Login.jsp");
			}
			
		}
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Stablishing the content type of the response
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession();
		//Getting the parameters from the form
		String adminName = request.getParameter("adminName");
		String password = request.getParameter("password");
		
		if(adminService.authentication(adminName, password)){
			//Settings the attributes of the http session
			session.setAttribute("adminName",adminName);
			session.setAttribute("password",password);
			doGet(request, response);
		} else {
			pw.println("Username or password incorrect");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
			requestDispatcher.include(request, response);
		}

	}

}
