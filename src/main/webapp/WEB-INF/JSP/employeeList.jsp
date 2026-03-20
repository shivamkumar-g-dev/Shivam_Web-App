<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Department</th>
        <th>Address</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.username}</td>
            <td>${employee.department}</td>
            <td>${employee.address}</td>
        </tr>
    </c:forEach>
    
    <c:forEach var="emp" items="${employees}">
    	${emp.username} - ${emp.department} - ${emp.address}

    	<a href="edit/${emp.id}">Edit</a>
    	<a href="delete/${emp.id}">Delete</a>
    	<br><br>
	</c:forEach>
</table>


</body>
</html>