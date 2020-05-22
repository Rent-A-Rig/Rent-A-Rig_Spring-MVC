<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<h2 align="center">Sign-In</h2>
		<form:form id="loginForm" modelAttribute="login" action="loginProcess"
			method="post">
			<table align="center">
				<div class="form-group">
				<tr>
					<td><form:label path="username">Username: </form:label></td>
					<td><form:input path="username" name="username" id="username" />
						<form:errors path="username"></form:errors></td>
				</tr>
				</div>

				<div class="form-group">
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:password path="password" name="password"
							id="password" /> <form:errors path="password"></form:errors></td>
				</tr>
				
				</div>
				
				<div class="checkbox">
					<tr>
					<td><label><input type="checkbox"> Remember me</label></td>
					</tr>
				</div>
				
				<tr>
			
					<td><form:button id="login" name="login" class="btn btn-primary">Login</form:button>
					</td>
				</tr>
				
				<tr>
					<td><a href="home">Home</a></td>
				</tr>
				<tr>
					<td><a href="register">Create your Rent-A-Rig account</a></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>