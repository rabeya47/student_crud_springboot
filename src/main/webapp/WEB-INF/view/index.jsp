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
		<div class="row justify-content-center">
			<div class="col-md-6 mt-5">
				<h4>Login Please</h4>
				<c:if test="${data.status.equals('Failed')}">
					<div class="alert alert-danger" role="alert">
					  ${data.message}
					</div>
				</c:if>
				
				<c:if test="${data.status.equals('Success')}">
					<div class="alert alert-success" role="alert">
					  ${data.message}
					</div>
				</c:if>
<form action="/login" method="post">

<div class="mb-3">
<label for="username" class="form-label">Usesrname</lable>
<input type="text" class="form-control" name="username" id="username">
</div>


<div class="mb-3">
<label for="password" class="form-label">Password</lable>
<input type="password" class="form-control" name="password" id="password">
</div>




<button type="submit" class="btn btn-primary">Login</button>

</form>


</div>
</div>
</div>
</body>
</html>

