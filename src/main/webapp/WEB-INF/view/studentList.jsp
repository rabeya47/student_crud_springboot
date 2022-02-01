<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>


	<div class="container">
		<div class="table-responsive">
			<a href="/add" class="link-secondary">Add a new
				student</a>
			<div class="row">
				<div class="col-md-8">
					<h4>Student List</h4>
				</div>
				<div class="col-md-4">
					<form action="/search" method="get">
						<div class="input-group mb-3">
							<input type="text" class="form-control" name="searchText"
								placeholder="Search student" aria-label="Search student"
								aria-describedby="basic-addon2"> 
								<button id="basic-addon2" class="input-group-text" type="submit">Search</button>								
						</div>
					</form>
				</div>
			</div>
<table class="table table-responsive">
<thead>
	<tr>
		<th>Id</th>
		<th>Student Name</th>
		<th>Gender</th>
		<th>Course</th>
		<th>Contact</th>
		<th>Address</th>
		<th>Action</th>
	</tr>
</thead>

<tbody>
	<c:forEach var="s" items="${data.stuList}">
	<tr>
		<td>${s.id}</td>
		<td>${s.name}</td>
		<td>${s.gender}</td>
		<td>${s.course}</td>
		<td>${s.contact}</td>
		<td>${s.address}</td>
		<td>
			<a href="/edit/${s.id}">Edit</a> |
			<a href="/delete/${s.id}">Delete</a>
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</div>
</div>

</body>
</html>