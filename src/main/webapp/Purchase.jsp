<%@page import="com.entity.Purchase" %>
<%@page import="com.entity.Flight" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book your Flight!</title>
</head>
<body>
<%
	Object obj = request.getAttribute("flight");
	Flight flight = (Flight)obj;
%>
	<div>
		<h2>Details of your flight</h2>
			<span>Source: <%= flight.getSource() %></span>
			<span>Destiny: <%= flight.getDestiny() %></span>
			<span>Date: <%= flight.getFlightDate() %></span>
			<span>Airline: <%= flight.getAirline().getName() %></span>
			<span>Price: <%= flight.getPrice() %></span>
	</div>
	<div>
		<h3>Insert your personal data:</h3>
		<form action="ConfirmationController" method="post">
			<label>Name</label>
			<input type="text" name="name" required><br/>
			<label>Last Name</label>
			<input type="text" name="lastName" required><br/>
			<label>Last Name</label>
			<input type="text" name="lastName" required><br/>
			<label>email</label>
			<input type="email" name="email" required><br/>
			<label>Number of passengers</label>
			<input type="number" name="passengersNumber"><br/>
			<input type="hidden" id=flightId name="flightId" value="<%= String.valueOf(flight.getflightId()) %>"/>
			<input type="submit" value="search">
			<input type="reset" value="reset">
		</form>
	</div>
</body>
</html>
