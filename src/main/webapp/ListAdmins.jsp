
<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Admin" %>
<%@page import="java.util.List" %>
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
	Object obj = request.getAttribute("listOfAirlines");
	List<Admin> list = (List)obj;
	Iterator<Admin> li = list.iterator();
	while(li.hasNext()){
		Admin a = li.next();
	%>
	<div>
		<span>Name:<%= a.getUsername() %> </span>
	</div>
	<%
	}
	%>
</body>
</html>