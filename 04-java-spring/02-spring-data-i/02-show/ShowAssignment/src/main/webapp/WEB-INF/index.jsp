<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to books dot com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome to books dot com</h1>
<a href="/new">Create a new Book</a>
<br>
<table class="table table-dark">
<thead>
<td>Id</td>
<td>Title</td>
<td>Description</td>
<td>Language</td>
<td>Pages</td>
</thead>
<tbody>
<c:forEach items="${allbooks}" var="book">
<tr>

<td>${book.id}</td>
<td>${book.title}</td>
<td>${book.description}</td>
<td>${book.language}</td>
<td>${book.pages}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>