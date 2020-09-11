<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>Products and Categories</title>
</head>
<body>
	<div class="container">
		<nav>
			<h3><a href="/">Products</a> | <a href="/categories">Categories</a></h3>
		</nav>
		<h2>${ category.name }</h2>
		<h3>Products</h3>
	 <ul>
		<c:forEach items="${ allProducts }" var="product">
			<li>${ product.name }</li>	
		</c:forEach>
		</ul>
		<h3>Add Product</h3>
		<form method="post" action="/categories/${category.id}">
		<select name="addProdToCat">
		<c:forEach items="${ products }" var="prod">
		        <option value="${ prod.id }">${ prod.name }</option>
		</c:forEach> 
		</select>
		<button>Add Product</button>
		</form>
	</div>
</body>
</html>