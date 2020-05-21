<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>

<!-- Latest compiled and minified CSS -->
<link href='<"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">'>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>	
	
<link href='<spring:url value="/resources/css/mainStyles.css"/>'
	rel="stylesheet">
	
	<link href='<spring:url value="/resources/css/products.css"/>'
	rel="stylesheet">
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<c:forEach var="product" items="${products}">
		
			<div class="col-md-5">
				<img class="img-fluid rounded center-block"
					src='<c:url value="/resources/images/${product.id}.jpg"/>' alt="">
					
			</div>
			<div class="col-md-7">
				<h3>${product.name}</h3>
				<p>${product.shortDesc}</p>
				<p>
					<b>Pricing: </b> ${product.price}
				</p>
				<form action="addToCart">
					<div class="number-input md-number-input float-left">
						<button type="button"
							onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
							class="minus"></button>
						<input class="quantity" min="0" name="quantity" value="1"
							type="number">
						<button type="button"
							onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
							class="plus"></button>
					</div>
					
					<input type="hidden" name="product" value="${product}">
					<input type="hidden" name="products" value="${products}">
					<button type="submit" class="btn btn-primary">Add to Cart</button>
				</form>
			</div>
			<div id="accordion" role="tablist" aria-multiselectable="true">
				<div class="card">
					<div class="card-header" role="tab"
						id="headingOne">
						<h5 class="mb-0">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#Overview" aria-expanded="false"
								aria-controls="Overview"> Overview </a>
						</h5>
					</div>

					<div id="Overview" class="collapse"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="card-block"><${product.longDesc}</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header" role="tab"
						id="headingTwo">
						<h5 class="mb-0">
							<a class="collapsed" data-toggle="collapse"
								data-parent="#accordion" href="#Specs"
								aria-expanded="false" aria-controls="Specs">
								Specifications </a>
						</h5>
					</div>
					<div id="Specs" class="collapse" role="tabpanel"
						aria-labelledby="headingTwo">
						<div class="card-block">
							<ul>
								<li>${product.shortDesc}</li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>

			<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>