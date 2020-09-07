<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css" />
<title>DriversLicense</title>
</head>
<body>
	<div class="container">
		<a class="float-right" href="/persons/new">Create New Person</a>
		<br>
		<a class="float-right" href="/licenses/new">Register New</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>License Number</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ persons }" var="person">
				<tr>
					<td><a href="/persons/${person.id}">${ person.firstName }</a></td>
					<td>${ person.lastName }</td>
					<td>${person.license.number}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>