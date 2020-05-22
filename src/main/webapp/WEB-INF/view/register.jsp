<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<h2 align="center">Create account</h2>
	<form:form action="registerProcess" method="post" modelAttribute="user">
		<table align="center">
			<div class="form-group">
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td>
					<form:input path="username" name="username" id="username" placeholder="Enter username"/>
					<form:errors path="username"></form:errors>
				</td>	
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="password">Password: </form:label></td>
				<td>
					<form:password path="password" name="password" id="password" placeholder="Enter password"/>
					<form:errors path="password"></form:errors>
				</td>
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="firstname">FirstName: </form:label></td>
				<td>
					<form:input path="firstname" name="firstname" id="firstname" placeholder="Enter firstname"/>
					<form:errors path="firstname"></form:errors>
				</td>
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="lastname">LastName: </form:label></td>
				<td>
					<form:input path="lastname" name="lastname" id="lastname" placeholder="Enter lastname"/>
					<form:errors path="lastname"></form:errors>
				</td>
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="email">Email: </form:label></td>
				<td>
					<form:input path="email" name="email" id="email" placeholder="Enter email"/>
					<form:errors path="email"></form:errors>
					<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				</td>
			</tr>
			</div>
			
			<div class="form-group">
			<tr>
				<td><form:label path="phone">Phone: </form:label></td>
				<td>
					<form:input path="phone" name="phone" id="phone" placeholder="Ex:(123)456-7890" />
					<form:errors path="phone"></form:errors>
				</td>
			</tr>
			</div>
			
			<tr>
				<td></td>
				<td><form:button id="register" name="register" class="btn btn-primary">Register</form:button>
				</td>
			</tr>
			
			
			<tr>
				<td><a href="home">Home</a></td>
			</tr>
			<tr>
				<td><a href="login">Already have an account ? Sign-In</a></td>
			</tr>
		</table>
	</form:form>
	</div>
	
</body>
</html>
