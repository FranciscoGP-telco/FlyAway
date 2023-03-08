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

import com.service.AdminService;


@WebServlet("/Password")
public class PasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminService();
	
    public PasswordController() {
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
				//RequestDispatcher to send the info to the jsp file
				rd = request.getRequestDispatcher("/WEB-INF/Password.jsp");
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
		HttpSession httpSession = request.getSession();
		
		//Getting the parameters from the session
		String adminName = (String) httpSession.getAttribute("adminName");
		String password = (String) httpSession.getAttribute("password");
		
		//Getting the new pasword from de form
		String newPassword = request.getParameter("newPassword");
		
		System.out.println(adminName + " holaaaa " + password);
		//checking the credentials
		if(adminService.authentication(adminName, password)){
			//Creation of purchaseService Object and sending the object to store it in the DB
			AdminService adminService = new AdminService();
			String result = adminService.changePassword(adminName, newPassword);
			pw.println(result + " Please login again");
			
		} else {
			pw.println("Username or password incorrect");
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
		requestDispatcher.include(request, response);
	}

}
