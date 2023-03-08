
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List" %>
<%@page import="com.entity.Flight" %>
<%@page import="com.entity.Airline" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page - List with all the Admins</title>
</head>
<body>
	<h1>ADMIN PAGE</h1>	
	<h2>List of possible sources</h2>
	<%
	Object obj = request.getAttribute("listOfSources");
	
	if(obj != null){
		List<String> list = (List)obj;
		Iterator<String> li = list.iterator();
		while(li.hasNext()){
			String source = li.next();

	%>
	<div>
			<span><%= source %></span><br/>
	</div>
	<%
		}
	}
	%>
	<h2>List of possible destinies</h2>
	<%
	obj = request.getAttribute("listOfDestinies");
	
	if(obj != null){
		List<String> list = (List)obj;
		Iterator<String> li = list.iterator();
		while(li.hasNext()){
			String destiny = li.next();

	%>
	<div>
			<span><%= destiny %></span><br/>
	</div>
	<%
		}
	}
	%>
	<h2>List of all flights</h2>
	<%
	obj = request.getAttribute("listOfFlights");
	
	if(obj != null){
		List<Flight> list = (List)obj;
		Iterator<Flight> li = list.iterator();
		while(li.hasNext()){
			Flight flight = li.next();
	%>
	<div>
			<span>Source: <%= flight.getSource() %></span>
			<span>Destiny: <%= flight.getDestiny() %></span>
			<span>Price: <%= flight.getPrice() %></span>
			<span>Date: <%= flight.getFlightDate() %></span>
			<span>Airline: <%= flight.getAirline().getName() %></span><br/>
	</div>
	<%
		}
	}
	%>
	<h2>List of all airlines</h2>
	<%
	obj = request.getAttribute("listOfAirlines");
	
	if(obj != null){
		List<Airline> list = (List)obj;
		Iterator<Airline> li = list.iterator();
		while(li.hasNext()){
			Airline airline = li.next();
	%>
	<div>
			<span><%= airline.getName() %></span><br/>
	</div>
	<%
		}
	}
	%>
	<h3>Do you want to change your password? Use this link:</h3>
	<a href="Password">Password change</a>
</body>
</html>