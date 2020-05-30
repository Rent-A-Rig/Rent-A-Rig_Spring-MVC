<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href='<spring:url value="/resources/css/myAccount.css"/>'
	rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	<br>

	<div class="welcome1">
		<h1>W * E * L * C * O * M * E</h1>
		<h5>this your your account information page... Please don't let
			anyone else see it. that's how identity theft happens.</h5>
	</div>
	<div class="container">
		<h2 align="center">My Account Information</h2>
		<form:form modelAttribute="user">
			<table align="center">
				<div class="form-group">
					<tr>
						<td><form:label path="username">Username: ${cookie.username.value}</form:label></td>
						<td><form:errors path="username" class="text-danger"></form:errors>
						</td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td><form:label path="firstname">FirstName: ${cookie.firstname.value}</form:label></td>
						<form:errors path="firstname" class="text-danger"></form:errors>
						</td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td><form:label path="lastname">LastName: ${cookie.lastname.value }</form:label></td>
						<form:errors path="lastname" class="text-danger"></form:errors>
						</td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td><form:label path="email">Email: ${cookie.email.value }</form:label></td>
						<form:errors path="email" class="text-danger"></form:errors>
						</td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td><form:label path="phone">Phone: ${cookie.phone.value }</form:label></td>
						<form:errors path="phone" class="text-danger"></form:errors>
						</td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td><form:label path="line1">Line 1: ${cookie.line1.value }</form:label></td>
						<form:errors path="line1" class="text-danger"></form:errors>
						</td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td><form:label path="line2">Line 2/City: ${cookie.line2.value }</form:label></td>
						<form:errors path="line2" class="text-danger"></form:errors>
						</td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td><form:label path="state">State: ${cookie.state.value }</form:label></td>
						<form:errors path="state" class="text-danger"></form:errors>
						</td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td><form:label path="zip">Zip Code: ${cookie.zip.value }</form:label></td>
						<form:errors path="zip" class="text-danger"></form:errors>
						</td>
					</tr>
				</div>

				<tr>
					<td><a href="address">Add/Change Address</a>
					<td><a href="home">Home</a></td>
				</tr>
			</table>
		</form:form>
	</div>



	<div class="bodystuff">
		<p>
			<u>Username:</u><br>${cookie.username.value}</p>
		<br>
		<p>
			<u>first name:</u><br> ${cookie.firstname.value}
		</p>
		<br>
		<p>
			<u>last name:</u><br> ${cookie.lastname.value}
		</p>
		<br>
		<p>
			<u>email:</u><br> ${cookie.email.value}
		</p>
		<br>
		<p>
			<u>phone:</u><br> ${cookie.phone.value}
		</p>
	</div>
	<br>
	<br>
	<h2 class="footernotes">More Features Will Be Coming Soon... To A
		Rent-A-Rig Near You! ;)</h2>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>