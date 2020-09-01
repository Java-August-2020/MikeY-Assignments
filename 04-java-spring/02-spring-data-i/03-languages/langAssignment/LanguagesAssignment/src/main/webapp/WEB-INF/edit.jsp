<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<h1>Edit Language</h1>
		<c:out value="${language.id} "/>
		<form:form action="/${ language.id }" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">
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
		        <form:label path="version">Current Version</form:label>
		        <form:errors path="version"/>
		        <form:input class="form-control" path="version"/>
		    </div>
		    <input type="submit" value="Submit"/>
		</form:form>
		<form action="/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input class="btn btn-danger" type="submit" value="Delete">
	    </form>
	    </div>
	    </body>
	    </html>
	    