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
		<h2>${ product.name }</h2>
		<h3>Categories</h3>
	 <ul>
		<c:forEach items="${ allCategories }" var="category">
			<li>${ category.name }</li>	
		</c:forEach>
		</ul>
		<h3>Add Category</h3>
		<form method="post" action="/products/${product.id}">
		<select name="addCatToProd">
		<c:forEach items="${ categories }" var="cat">
		        <option value="${ cat.id }">${ cat.name }</option>
		</c:forEach> 
		</select>
		<button>Add Category</button>
		</form>
	</div>
</body>
</html>