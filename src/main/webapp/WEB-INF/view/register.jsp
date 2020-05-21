<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href='<spring:url value="/resources/css/mainStyles.css"/>' rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>

	<form:form action="registerProcess" method="post" modelAttribute="user">
		<table align="center">
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td>
					<form:input path="username" name="username" id="username"/>
					<form:errors path="username"></form:errors>
				</td>
				
				
				
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td>
					<form:password path="password" name="password" id="password" />
					<form:errors path="password"></form:errors>
				</td>
			</tr>
			
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td>
					<form:input path="firstname" name="firstname" id="firstname" />
					<form:errors path="firstname"></form:errors>
				</td>
			</tr>
			
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td>
					<form:input path="lastname" name="lastname" id="lastname" />
					<form:errors path="lastname"></form:errors>
				</td>
			</tr>
			
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td>
					<form:input path="email" name="email" id="email" />
					<form:errors path="email"></form:errors>
				</td>
			</tr>

			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td>
					<form:input path="phone" name="phone" id="phone" />
					<form:errors path="phone"></form:errors>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home">Home</a></td>
			</tr>
		</table>
	</form:form>
	<a href="login">Go to Login Page</a>
</body>
</html>
