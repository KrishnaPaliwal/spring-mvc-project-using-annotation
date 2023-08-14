<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    <ul>
        <c:forEach items="${employees}" var="employee">
            <li>
                ${employee.firstName} ${employee.lastName} - ${employee.age}
                <a href="${pageContext.request.contextPath}/delete/${employee.id}">Delete</a>
            </li>
        </c:forEach>
    </ul>
    <a href="${pageContext.request.contextPath}/add">Add Employee</a>
</body>
</html>
