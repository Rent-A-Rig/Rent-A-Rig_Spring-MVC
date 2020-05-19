<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account</title>
</head>
<body>
<p>
		Hello,
		${user.firstname}</p>
	<br>
	<p>
		Username:
		<%=request.getParameter("username")%></p>
	<p>
		first name:
		<%=request.getParameter("firstname")%></p>
	<p>
		last name:
		<%=request.getParameter("lastname")%></p>
	<p>
		email:
		<%=request.getParameter("email")%></p>
	<p>
		phone:
		<%=request.getParameter("phone")%></p>
	<br>
	
</body>
</html>