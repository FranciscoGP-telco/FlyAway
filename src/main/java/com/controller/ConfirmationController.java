package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmationController
 */
@WebServlet("/ConfirmationController")
public class ConfirmationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConfirmationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();  
		response.setContentType("text/html");
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		int tlfnNumber = Integer.parseInt(request.getParameter("tlfnNumber"));
		String email = request.getParameter("email");
		session.setAttribute("name",name);
		session.setAttribute("lastName",lastName);
		session.setAttribute("tlfnNumber",tlfnNumber);
		session.setAttribute("email",email);
		//request.setAttribute("flight", flight);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Confirmation.jsp");
		requestDispatcher.include(request, response);
	}

}
