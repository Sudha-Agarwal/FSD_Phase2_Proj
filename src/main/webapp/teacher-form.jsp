<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
		<h1>Teacher Management</h1>
		<h2>
			<a href="new">Add New Teacher</a> &nbsp;&nbsp;&nbsp; <a href="list">List
				All Teachers</a>
		</h2>

		<form action="addNewTeacher" method="post">
			Teacher Name: <input type="text" name="teacherName" size="45">
			<br /> <br /> <input type="submit" value="Submit" />
		</form>

	</center>
</body>
</html>