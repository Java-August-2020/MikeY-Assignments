<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
        <title>Enter Code</title>
       	<link rel="stylesheet" href="css/style.css"/>
	</head>
	<body>
        <p>What is the code?</p>
        <form method="post" action="/attempt">
        <span><c:out value="${ error }" /></span>
		<input type="text" name="guess">
		<button>Try Code</button>
		</form>
	</body>
</html>