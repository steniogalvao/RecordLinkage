<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>


<body>

	<h2>Registration Form</h2>

	<form:form method="POST" modelAttribute="user">
		<form:input type="hidden" path="id" id="id" />

		<div class="form-group">
			<label for="email">E-mail: </label> <input type="text"
				class="form-control" id="email" path="email">
		</div>
		<div class="form-group">
			<label for="password">Password: </label> <input type="password"
				class="form-control" id="password"path="password">
		</div>
		<button type="submit" value="Login" class="btn btn-default">Login</button>
		
		
	</form:form>
	<br />
	<br />
</body>
</html>