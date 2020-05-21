<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<link href='<spring:url value="/resources/css/mainStyles.css"/>'
	rel="stylesheet">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>

	<c:forEach var="product" items="${cartRedirectEntity.products}">
		<table>
			<tr>
				<th>${product.name}</th>
			</tr>
			<tr>
				<td>Product ID: ${product.id}</td>
			</tr>
			<tr>
				<td>Product Price: ${product.price}</td>
			</tr>
			<tr>
				<td>Product Inventory: ${product.category}</td>
			</tr>
			<tr>
				<td>Product Inventory: ${product.inventory}</td>
			</tr>
			<tr>
				<td>Product Desc1: ${product.shortDesc}</td>
			</tr>
			<tr>
				<td>Product Desc2: ${product.longDesc}<br></td>
			</tr>
		</table>
		<form:form modelAttribute="cartRedirectEntity" action="addToCart">
			<form:hidden path="filter" value="${cre.filter}"/>
			<form:hidden path="prodID" value="${product.id}" />
			<form:input path="quantity" value = "1"/>
			<input type="submit" value="Submit"/>
		</form:form>

	</c:forEach>

	<jsp:include page="footer.jsp"></jsp:include>



</body>
</html>