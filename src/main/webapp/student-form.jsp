<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/simplilearn"  
     user="root"  password="root"/>  
     
     <sql:query dataSource="${db}" var="ListClasses">  
SELECT * from class;  
</sql:query>  

<center>
	<h1>User Management</h1>
	<h2>
		<a href="new">Add New Student</a> &nbsp;&nbsp;&nbsp; <a href="list">List
			All Students</a>
	</h2>
	</center>


	<form action="addNewStudent" method="post">
		Student Name: <input type="text" name="studentName" size="45">
		Select a Class:&nbsp; <select name="classes">
			<c:forEach items="${ListClasses.rows}" var="classes">
				<option value="${classes.class_id}">${classes.class_name}</option>
			</c:forEach>
		</select> <br />
		<br /> <input type="submit" value="Submit" />
	</form>

</body>
</html>