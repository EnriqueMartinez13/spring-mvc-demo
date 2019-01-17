<!DOCTYPE html>
<html>
<head>
<title>Hola mundo</title>
</head>
<body>

	<form action="processFormVersionThree" method="GET">
		<input type="text" name="studentName" placeholder="¿Cual es su nombre?" />
		<input type="submit"/>
	</form>

	<a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>