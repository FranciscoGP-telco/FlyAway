<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change your password</title>
</head>
<body>
	<div>
		<h2>Insert your new Password</h2>
		<form action="Password" method="post">
			<label>New Password:</label>
			<input type="password" name="newPassword" required><br/>
			<input type="submit" value="Change">
			<input type="reset" value="reset">
		</form>
	</div>
</body>
</html>