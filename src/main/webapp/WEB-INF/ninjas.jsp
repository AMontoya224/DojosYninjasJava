<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			New Ninja
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
	</head>
	<body>
		<h1>
			New Ninja
		</h1>
		<main>
			<form:form method="POST" action="/ninjas/new" modelAttribute="ninjas">
				<div>
					<p><form:errors path="firstName" class="error"/></p>
					<p><form:errors path="lastName" class="error"/></p>
					<p><form:errors path="age" class="error"/></p>
				</div>
				<div class="justify">
					<form:label path="dojo">
						Select Dojo:
					</form:label>
					<form:select path="dojo">
						<c:forEach var="dojo" items="${dojosList}">
							<form:option value="${dojo}">
								<c:out value="${dojo.getName()}"></c:out>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="justify">
					<form:label path="firstName" for="firstName">
						First Name:
					</form:label>
					<form:input path="firstName" type="text" name="firstName" id="firstName" />
				</div>
				<div class="justify">
					<form:label path="lastName" for="lastName">
						Last Name:
					</form:label>
					<form:input path="lastName" type="text" name="lastName" id="lastName" />
				</div>
				<div class="justify">
					<form:label path="age" for="age">
						Age:
					</form:label>
					<form:input path="age" type="number" name="age" id="age" />
				</div>
				<button type="submit" class="submit" >
					Create
				</button>
			</form:form>
		</main>
	</body>
</html>