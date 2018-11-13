<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Food</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-5cy8WdlNAGqQwyB33aLiqJoRQQxZsc3TDUkSTahHAx2gMK3o0te7Xqm+nNLe4Ou3"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<div class="container">

		<!-- This is an html comment -->
		<%-- This is a jsp comment used for EL and java code <h2> ${food } </h2> --%>
		<h1>Food</h1>
		<form action="/food">
		<input type="text" value="${category}" name="category" placeholder="Category">
		<input class="btn btn-primary" type="submit" value="Search">
		
		<c:if test="${ not empty category }">
		<!-- the if statement determines whether the clear link shows on the page or not -->
			<a href="/food" class="btn btn-secondary">Clear</a>
		</c:if>
		
		</form>


		<table class="table">
			<thead>
			<tr>
				<th>Name</th>
				<th>Category</th>
				<th>Description</th>
				<th>Update</th>
				<th>Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${food}" var="f">
					<tr>
					<!-- We can access nested properties using the 
					variable names that match in our pojo -->
						<td>${f.name}</td>
						<td>${f.category}</td>
						<td>${f.description}</td>
						<td><a class="btn btn-primary" href="/update?id=${f.id}">Edit</a></td>
						<td><a class="btn btn-primary" href="/delete?id=${f.id}">Delete</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		
		<a href="add-food" class="btn btn-secondary">Add</a>
	</div>
</body>
</html>