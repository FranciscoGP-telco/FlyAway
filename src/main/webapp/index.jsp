<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway - You flights with the lower prices!</title>
</head>
<body>
	<form action="/FlightController" method="post">
		<label>Flight Date</label>
		<input type="date" name="flightdate"><br/>
		<label>Source of the flight</label>
		<input type="text" name="source"><br/>
		<label>Destiny of the flight</label>
		<input type="text" name="destiny"><br/>
		<label>Number of passengers</label>
		<input type="number" name="number"><br/>
		<input type="submit" value="search">
		<input type="reset" value="reset">
	</form>
</body>
</html>