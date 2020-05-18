<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var = "product" items = "${products}">
	<table>
		<tr>
			<th>${product.name}</th>
		</tr>
		<tr>
			<td>Product ID:        ${product.id}</td>
			<td>Product Inventory: ${product.inventory}</td>
			<td>Product Desc1:     ${product.shortDesc}</td>
			<td>Product Desc2:     ${product.longDesc}</td>
		</tr>
	</table>
	</c:forEach>
	
</body>
</html>