<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="my1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my2" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Employees</title>
</head>
<body>
	<a href="empform.html">Add Employee</a>
	<a href="viewEmployee.html">View Employee</a>

	<table border=1>
		<tr>
			<th>S.no</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Designation</th>
		</tr>
		<my1:forEach var="employee" items="${allEmployees}">
			
			<my1:url var="delete" value="deleteEmployee.html">
				<my1:param name="employeeId" value="${employee.id}"></my1:param>
			</my1:url>

			<my1:url var="update" value="updateEmployee.html">
				<my1:param name="employeeId" value="${employee.id}"></my1:param>
			</my1:url>
			<tr>
				<td>${employee.id}</td>
				<td>${employee.employeeName}</td>
				<td>${employee.employeeSalary}</td>
				<td>${employee.employeeDesignation}</td>
				<td><a href="${delete}">Delete</a></td>
				<td><a href="${update}">Update</a></td>
			</tr>
		</my1:forEach>


	</table>


</body>
</html>