<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pandas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
   <div class="jumbotron">
			<h1>Welcome</h1>
		</div>
		<div>
			<a href="/contact/new">Add Contact Info</a> | <a href="/students/new">New
			Students</a>
		</div>
		<hr>
		<div class="col-sm-8">
			<table class="table table-striped">
				<tr class="bg-dark text-light">
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
				</tr>
				<c:forEach items="${allStudents}" var="stu">
					<tr>
						<td>${stu.first_name} ${stu.last_name}</td>
						<td>${stu.age}</td>
						<td>${stu.student.address}</td>
						<td>${stu.student.city}</td>
						<td>${stu.student.state}</td>					
					</tr>
				</c:forEach>
			</table>
		</div>
  </div>
</body>
</html>