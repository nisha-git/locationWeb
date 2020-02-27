<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location List</title>
</head>
<body>

	<h4>${msg }</h4>
	<div class="row">
		<div class="col-lg-offset-6 col-lg-6">
			<a href="generateReport"> generate Location Report</a> <img
				src="report.jpeg" title="no Image">
		</div>
		<div class="col-lg-6">
			<table border="2 solid black">
				<c:forEach items="${locations}" var="location">
					<tr>
						<td>${location.name }</td>
						<td>${location.code }</td>
						<td>${location.type }</td>
						<td><a href="edit?id=${location.id}">Edit</a></td>
						<td><a href="delete?id=${location.id }">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</body>
</html>

