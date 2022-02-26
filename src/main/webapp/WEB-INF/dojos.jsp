<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			New Dojo
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
	</head>
	<body>
		<h1>
			New Dojo
		</h1>
		<main>
			<form:form method="POST" action="/dojos/new" modelAttribute="dojos">
				<div>
					<p><form:errors path="name" class="error"/></p>
				</div>
				<div class="justify">
					<form:label path="name" for="name">
						Name:
					</form:label>
					<form:input path="name" type="text" name="name" id="name" />
				</div>
				<button type="submit" class="submit" >
					Create
				</button>
			</form:form>
		</main>
	</body>
</html>