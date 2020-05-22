<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account</title>
</head>
<body>
	<p>Welcome to your account overview page. Below is your personal
		information. Don't let anyone else see it.</p>
	<br>
	<p>Username: ${cookie.username.value}</p>
	<p>first name: ${cookie.firstnameCookie.value}</p>
	<p>last name: ${cookie.lastnameCookie.value}</p>
	<p>email: ${cookie.emailCookie.value}</p>
	<p>phone: ${cookie.phoneCookie.value}</p>
	<br>

</body>
</html>