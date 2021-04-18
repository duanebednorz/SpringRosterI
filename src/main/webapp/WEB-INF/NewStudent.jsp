<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Roster I</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Contact Info</h1>
		</div>
		<div>
			<a href="/contact/new">Add Contact Info</a> | <a href="/students/new">New
				Students</a> | <a href="/dashboard">Student Dashboard</a>
			<hr>
			<div class="row">
				<div class="col-sm-4">
					<form:form action="/student/create" method="post"
						modelAttribute="aStudent">
						<div class="form-group">
							<label>First Name:</label>
							<form:input path="first_name" class="form-control" />
							<form:errors path="first_name" class="text-danger" />
						</div>
						<div class="form-group">
							<label>Last Name:</label>
							<form:input path="last_name" class="form-control" />
							<form:errors path="last_name" class="text-danger" />
						</div>
						<div class="form-group">
							<label>Age:</label>
							<form:input type="number" path="age" class="form-control" />
							<form:errors path="age" class="text-danger" />
						</div>
						<input type="submit" value="Add Student" class="btn btn-primary" />
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>