<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new book</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Add a new Book</h1>
<br>
<form:form method="POST" action="/" modelAttribute="book">
<div class="form-data">
    <form:label path="title">Title</form:label>
    <form:errors path="title"/>
    <form:input path="title"/>
</div>
    <form:label path="description">Description</form:label>
    <form:errors path="description"/>
    <form:textarea path="description"/>
    
    <form:label path="language">Language</form:label>
    <form:errors path="language"/>
    <form:input path="language"/>
    
    <form:label path="pages">Pages</form:label>
    <form:errors path="pages"/>     
    <form:input type="number" path="pages"/>
    
    <input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>

