<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<p>Username: ${cookie.username.value}</p>
	<p>first name: ${cookie.firstname.value}</p>
	<p>last name: ${cookie.lastname.value}</p>
	<p>email: ${cookie.email.value}</p>
	<p>phone: ${cookie.phone.value}</p>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>