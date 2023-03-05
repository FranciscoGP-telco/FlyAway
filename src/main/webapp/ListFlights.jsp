
<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Flight" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page - List with all the flights</title>
</head>
<body>
	<%
	Object obj = request.getAttribute("listOfFlights");
	List<Flight> list = (List)obj;
	Iterator<Flight> li = list.iterator();
	while(li.hasNext()){
		Flight f = li.next();
	%>
	<div>
		<span>Source: <%= f.getSource() %></span>
		<span>Destiny: <%= f.getDestiny() %></span>
		<span>Destiny: <%= f.getAirline().getName() %></span>
	</div>
	<%
	}
	%>
</body>
</html>