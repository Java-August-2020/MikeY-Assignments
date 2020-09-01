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
<link rel="stylesheet" href="css/main.css" />
<title>Languages App</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to Languages Dot Com!</h1>
		<a href="/new">Add a language...</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Language</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ languages }" var="language">
				<tr>
					<td><a href="/${ language.id }">${ language.language }</a></td>
					<td>${ language.creator }</td>
					<td>${ language.version }</td>
					<td>
						<a class="btn btn-primary" href="/${ language.id }/edit">Edit</a>
						<form id="delete-form" action="/${language.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input class="btn btn-danger" type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
			<form:form action="/" method="post" modelAttribute="language">
		    <div class="form-group">
		        <form:label path="language">Language Name</form:label>
		        <form:errors path="language"/>
		        <form:input class="form-control" path="language"/>
		    </div>
		    <div class="form-group">
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:input class="form-control" path="creator"/>
		    </div>
			<div class="form-group">
		        <form:label path="version">Version</form:label>
		        <form:errors path="version"/>
		        <form:input class="form-control" path="version"/>
		    </div>
		    <input type="submit" value="Submit"/>
		</form:form>
		<br>
	</div>
</body>
</html>