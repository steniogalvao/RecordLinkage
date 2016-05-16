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

	<h4 align="center">
		<ul class="list-group">
			<li class="list-group-item"><a
				href="<c:url value='/startProcess' />">START A NEW RECORD
					LINKAGE</a></li>
			<li class="list-group-item"><a
				href="<c:url value='/saveProducts' />">SAVE PRODUCT LIST IN BD</a></li>
			<li class="list-group-item"><a
				href="<c:url value='/saveListing' />">SAVE LISTING LIST IN BD</a></li>

		</ul>
		</4>

		<h2 align="center">LIST OF PRODUCTS</h2>
		<ul class="list-group">
			<li class="list-group-item">Products in the list:
				${productsSize}</li>
			<li class="list-group-item">Itens in search list: ${listingSize}</li>
			<li class="list-group-item">Products outside the search list:
				${productsOut}</li>
			<li class="list-group-item">Execution time: ${executionTime}s</li>
		</ul>
		<div class="well well-sm">
			<table class="table table-hover">
				<tr>
					<td><span class="label label-primary">Name</span></td>
					<td><span class="label label-primary">Manufacturer</span></td>
					<td><span class="label label-primary">Family</span></td>
					<td><span class="label label-primary">Model</span></td>
					<td><span class="label label-primary">Announced date</span></td>
					<td><span class="label label-primary">Found prices</span></td>
				</tr>
				<c:forEach items="${links}" var="link">
					<tr>
						<td>${link.product.product_name}</td>
						<td>${link.product.manufacturer}</td>
						<td>${link.product.family}</td>
						<td>${link.product.model}</td>
						<td>${link.product.announced_date}</td>
						<td>
							<ul class="list-group">
								<%-- 					<c:forEach items="${link.listings}" var="listing"> --%>
								<li class="list-group-item"><a
									href="<c:url value='/show-${link.product.product_name}-prices' />">show</a></li>
								<%-- 					</c:forEach> --%>
							</ul>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br />
</body>
</html>