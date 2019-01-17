<!DOCTYPE html>
<html>
<head>
<title>Hola mundo</title>


<link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/style.css">

<!-- <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script> -->
</head>

<body>

Hola Mundo
<br>

Nombre de Estudiante: ${param.studentName }

<br>

El mensaje del modelo es: ${message}

<br><br>
<img class="spring" src="${pageContext.request.contextPath}/resources/images/spring.png" /> 

<br><br>

<a href="http://localhost:8080/spring-mvc-demo/">home</a>

</body>
</html>