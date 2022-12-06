<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>

	<h1 align="center">Student List</h1>
	<div align="center">
		<form action="/student-management/add-new-student">
			<input type="submit" value="ADD NEW STUDENT">
		</form>
		<br>
		<table border="1">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Mobile</td>
					<td>Country</td>
				</tr>
			</thead>
			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td><a href="/student-management/update-student?userId=${student.id}">Update</a></td>
					<td><a href="/student-management/delete-student?userId=${student.id}"
							onclick="if(!(confirm('Are you sure oyu want to delete this student?'))) return false">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>