<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
        <title>Index</title>
	</head>
	<body>
	
		<form method="post" action="/result">
		<label for="name">Your name:</label>
		<input type="text" name="name"><br>
		<label for="location">Dojo Location:</label>
		<input type="text" name="location"><br>
		<label for="lang">Favorite Language:</label>
  		<select id="language" name="language">
		    <option value="Java">Java</option>
		    <option value="Python">Python</option>
		    <option value="Ruby">Ruby</option>
  		</select><br>
  		<label for="textbox">Comment (Optional)</label><br>
  		 <textarea name="message" rows="10" cols="40"></textarea><br>
		<button>Submit</button>
		</form>
	</body>
</html>