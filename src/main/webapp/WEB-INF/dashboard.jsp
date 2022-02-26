<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			Dojo Page
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style2.css">
	</head>
	<body>
		<h1>
			<c:out value="${dojo.getName()}"/> Ninjas
		</h1>
		<table>
        	<thead>
		        <tr>
		            <th>First Name</th>
		            <th>Last Name</th>
		            <th>Age</th>
		        </tr>
		    </thead>
        	<tbody>
				<c:forEach var="ninja" items="${dojo.getNinjaList()}">
					<tr>
                        <td><c:out value="${ninja.getFirstName()}"/></td>
                        <td><c:out value="${ninja.getLastName()}"/></td>
                        <td><c:out value="${ninja.getAge()}"/></td>
					</tr>
            	</c:forEach>
			</tbody>
		</table>
	</body>
</html>