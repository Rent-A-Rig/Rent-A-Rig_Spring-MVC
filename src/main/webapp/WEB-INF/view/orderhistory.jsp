<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	
	<c:forEach var="order" items="${orderhistory.orders}">
		<h2>Order ID: ${order.id}  - ${order.date}</h2>
	
		<table>
			<tr>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
			<c:forEach var="item" items="${order.items}"></c:forEach>
			<tr>
				<td>${item.product.name}</td>
				<td>${item.qty}</td>
				<td>${item.product.price}</td>
			</tr>
		</table>
	</c:forEach>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>