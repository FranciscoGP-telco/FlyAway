<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Finish your purchase</title>
</head>
<body>
	<div>
		<h2>Details of your purchase</h2>
		<span>Source: <%= session.getAttribute("flightSource") %></span><br/>
		<span>Destiny: <%= session.getAttribute("flightDestination") %></span><br/>
		<span>Date: <%= session.getAttribute("flightDate") %></span><br/>
		<span>Price: <%= session.getAttribute("flightPrice") %></span><br/>
		<span>Passenger: <%= session.getAttribute("passengersNumber") %></span><br/>
		<span>Total price: <%= (Integer)session.getAttribute("passengersNumber") * (Float)session.getAttribute("flightPrice") %></span>
	</div>
	<div>
		<h2>Your Personal data</h2>
		<span>Name: <%= session.getAttribute("name") %></span><br/>
		<span>Last Name: <%= session.getAttribute("lastName") %></span><br/>
		<span>Telephone number: <%= session.getAttribute("tlfnNumber") %></span><br/>
		<span>Email: <%= session.getAttribute("email") %></span><br/>
	</div>
	<div>
		<form action="Finish" method="post">
			<label>Card Number</label>
			<input type="text" name="CardNumber" minlength="16" maxlength="16" required ><br/>
			<input type="submit" value="Confirm Purchase">
			<input type="reset" value="reset">
		</form>
	</div>
</body>
</html>
