
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
	<%
	Object obj = request.getAttribute("listOfFlights");
	if(obj != null){
		List<Flight> list = (List)obj;
		Iterator<Flight> li = list.iterator();
		while(li.hasNext()){
			Flight flight = li.next();

	%>
	<div>
		<form action="Purchase" method="post">
			<span>Source: <%= flight.getSource() %></span>
			<span>Destiny: <%= flight.getDestiny() %></span>
			<span>Price: <%= flight.getPrice() %></span>
			<span>Date: <%= flight.getFlightDate() %></span>
			<span>Airline: <%= flight.getAirline().getName() %></span>
			<span>
				<input type="submit" value="book">
				<input type="hidden" id=flightId name="flightId" value="<%= String.valueOf(flight.getflightId()) %>"/>
			</span>
		</form>
	</div>
	<%
		}
	} else {
		%>
		<div>
			<span>We don't have any flight available with this data</span>
		</div>
		<%
	}
	%>
</body>
</html>