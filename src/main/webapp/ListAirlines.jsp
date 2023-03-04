
<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Airline" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page - List with all the Airlines</title>
</head>
<body>
	<%
	Object obj = request.getAttribute("listOfAirlines");
	List<Airline> list = (List)obj;
	Iterator<Airline> li = list.iterator();
	while(li.hasNext()){
		Airline a = li.next();
	%>
	<div>
		<span>Name:<%= a.getName() %> </span>
	</div>
	<%
	}
	%>
</body>
</html>