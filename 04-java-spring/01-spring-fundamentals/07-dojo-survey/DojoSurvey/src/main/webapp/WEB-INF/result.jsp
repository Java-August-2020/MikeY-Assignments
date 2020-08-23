<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
        <title>Results</title>
	</head>
	<body>
        <h2>Submitted Info</h2>
        <p><strong>Name:</strong> <c:out value="${ name }"/></p>
		<p><strong>Dojo Location:</strong> <c:out value="${ location }"/></p>
		<p><strong>Favorite Language:</strong> <c:out value="${ language }"/>!!!</p>
		<p><strong>Comment:</strong> <c:out value="${ message }"/><br>
		<a href="/"><button>Go Back</button></a>
	</body>
</html>