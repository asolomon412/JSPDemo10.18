<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-5cy8WdlNAGqQwyB33aLiqJoRQQxZsc3TDUkSTahHAx2gMK3o0te7Xqm+nNLe4Ou3"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<div class="container">
		<h1>Add Food</h1>
		<form action="/update-food" method="post">
			ID: ${id} <input type="hidden" value="${id}" name="id">
			Name: <input type="text" name="name"><br> 
			Category: <input type="text" name="category"><br> 
			Description: <input type="text" name="description"><br> 
			<input class="btn btn-primary" type="submit" value="Add">
		</form>
	</div>

</body>
</html>