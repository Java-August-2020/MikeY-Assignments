<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
        <title>Counter Page</title>
	</head>
	<body>
        <p>You have visited: <c:out value="${count}"/> times</p>
	<a href="/">Test another visit?</a>
	<a href="/reset"><button>Reset Session</button></a>
	</body>
</html>