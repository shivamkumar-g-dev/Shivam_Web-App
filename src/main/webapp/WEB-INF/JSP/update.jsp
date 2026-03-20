<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body bgcolor="lightblue">

<h2>Update Employee Details</h2>

<form action="updateEmployee" method="post">

	<input type="hidden" name="id" value="${employee.id}" />

	<label>Username:</label>
	<input type="text" name="username" value="${employee.username}" />
	<br><br>

	<label>Department:</label>
	<input type="text" name="department" value="${employee.department}" />
	<br><br>

	<label>Address:</label>
	<input type="text" name="address" value="${employee.address}" />
	<br><br>

	<button type="submit">Update</button>

</form>

</body>
</html>