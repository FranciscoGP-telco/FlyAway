<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login webpage</title>
</head>
<body>
	<div>
		<h2>Insert you username and password</h2>
		<form action="Admin" method="post">
			<label>User Name:</label>
			<input type="text" name="adminName" required><br/>
			<label>Password:</label>
			<input type="password" name="password" required><br/>
			<input type="submit" value="Enter">
			<input type="reset" value="reset">
		</form>
	</div>
</body>
</html>