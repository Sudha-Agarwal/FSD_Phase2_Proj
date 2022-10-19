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
		url="jdbc:mysql://localhost/simplilearn" user="root" password="root" />

	<sql:query dataSource="${db}" var="ListClasses">  
SELECT * from class;  
</sql:query>


	<sql:query dataSource="${db}" var="ListTeacher">  
SELECT * from teacher;  
</sql:query>
	<center>

		<form action="AssignTeacherToClass" method="post">
			Student Name: <input type="text" name="studentName" size="45">
			Select a Teacher:&nbsp; <select name="teachers">
				<c:forEach items="${ListTeacher.rows}" var="teacher">
					<option value="${teacher.teacher_id}">${teacher.teacher_name}</option>
				</c:forEach>
			</select> <br /> <br /> Select a Class:&nbsp; <select name="classes">
				<c:forEach items="${ListClasses.rows}" var="classes">
					<option value="${classes.class_id}">${classes.class_name}</option>
				</c:forEach>
			</select> <br /> <input type="submit" value="Submit" />
		</form>
	</center>
</body>
</html>