<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>


<body>

	<a></a>
	<h2>${link.product.product_name}</h2>

	<div class="well well-sm">
		<table class="table table-hover">
			<tr>
				<td><span class="label label-primary">Currency</span></td>
				<td><span class="label label-primary">price</span></td>
				<td><span class="label label-primary">description</span></td>
			</tr>
			<c:forEach items="${link.listings}" var="listing">
				<tr>
					<td>${listing.currency}</td>
					<td>${listing.price}</td>
					<td>${listing.title}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />
</body>
</html>