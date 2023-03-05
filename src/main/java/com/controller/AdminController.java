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
import com.service.AdminService;

/**
 * Servlet implementation class AdminController
 */
//@WebServlet(urlPatterns = "/ListAdmins.jsp", name = "AdminController")
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		AdminService adminService = new AdminService();
		List<Admin> listOfAllAdmins = adminService.findAllAdmins();
		request.setAttribute("listOfAllAdmins", listOfAllAdmins);
		RequestDispatcher rd = request.getRequestDispatcher("/ListAdmins.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
