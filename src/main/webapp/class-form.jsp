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
		<h1>Class Management</h1>
		<h2>
			<a href="new">Add New Class</a> &nbsp;&nbsp;&nbsp; <a href="list">List
				All Classes</a>
		</h2>

		<form action="addNewClass" method="post">
			Class Name: <input type="text" name="className" size="45">
			<br /> <br /> <input type="submit" value="Submit" />
		</form>

	</center>
</body>
</html>