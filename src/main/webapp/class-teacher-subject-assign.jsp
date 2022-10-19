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

	<sql:query dataSource="${db}" var="ListSubject">  
SELECT * from subject;  
</sql:query>
	<center>

		<form method="post">
			Select a Class:&nbsp; <select name="classes">
				<c:forEach items="${ListClasses.rows}" var="classes">
					<option value="${classes.class_id}">${classes.class_name}</option>
				</c:forEach>
			</select> <br /> Select a Teacher:&nbsp; <select name="teachers">
				<c:forEach items="${ListTeacher.rows}" var="teacher">
					<option value="${teacher.teacher_id}">${teacher.teacher_name}</option>
				</c:forEach>
			</select> <br /> <br /> Select a Subject:&nbsp; <select name="subjects">
				<c:forEach items="${ListSubject.rows}" var="subject">
					<option value="${subject.subject_id}">${subject.subject_name}</option>
				</c:forEach>
			</select> <br /> <input type="submit" value="Submit" />
		</form>
	</center>

<c:if test="${pageContext.request.method=='POST'}">
<c:catch var="exception">
	<sql:update dataSource="${db}" var="insertTable">
INSERT INTO class_teacher_subject (class_id,teacher_id,subject_id) VALUES (?, ?, ?)

		<sql:param value="${param.classes}" />
		<sql:param value="${param.teachers}" />
		<sql:param value="${param.subjects}" />
	</sql:update>
	</c:catch>
	<c:if test="${insertTable>=1}">
<font size="5" color='green'> Congratulations ! Data inserted
successfully.</font>
<%request.getRequestDispatcher("index.jsp").include(request,response); %>
</c:if>
	<c:if test="${exception!=null}">
<c:out value="Unable to insert data in database." />
<!-- <%request.getRequestDispatcher("index.jsp").include(request,response); %> -->
</c:if>
	</c:if>
</body>
</html>