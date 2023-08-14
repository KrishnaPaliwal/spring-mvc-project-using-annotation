<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <h1>Add Employee</h1>
    <form method="post" action="${pageContext.request.contextPath}/add">
        First Name: <input type="text" name="firstName" /><br />
        Last Name: <input type="text" name="lastName" /><br />
        Age: <input type="number" name="age" /><br />
        <input type="submit" value="Add" />
    </form>
    <a href="${pageContext.request.contextPath}/">Back to Employee List</a>
</body>
</html>
