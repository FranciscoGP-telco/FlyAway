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
			<span>Source: <%= flight.getSource() %></span><br/>
			<span>Destiny: <%= flight.getDestiny() %></span><br/>
			<span>Date: <%= flight.getFlightDate() %></span><br/>
			<span>Airline: <%= flight.getAirline().getName() %></span><br/>
			<span>Price: <%= flight.getPrice() %></span><br/>
	</div>
	<div>
		<h3>Insert your personal data:</h3>
		<form action=Confirmation method="post">
			<label>Name</label>
			<input type="text" name="name" required><br/>
			<label>Last Name</label>
			<input type="text" name="lastName" required><br/>
			<label>Telephone number</label>
			<input type="number" name="tlfnNumber" required><br/>
			<label>email</label>
			<input type="email" name="email" required><br/>
			<label>Number of passengers</label>
			<input type="number" name="passengersNumber"><br/>
			<input type="hidden" id=flightId name="flightId" value="<%= String.valueOf(flight.getflightId()) %>"/>
			<input type="submit" value="book">
			<input type="reset" value="reset">
		</form>
	</div>
</body>
</html>
