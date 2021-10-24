<%@page import="com.jspCRUD.bean.StudentInfo"%>
<%@page import="com.jspCRUD.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	int rollnumber= Integer.parseInt(request.getParameter("rollnumber"));
	
	StudentDao dao=new StudentDao();
	
	StudentInfo s=new StudentInfo();
			
			s=dao.getRollNumber(rollnumber);
	
			
	
	
%>

<h2>Update Info</h2>
<br>
<hr>
<form action="UpdateStudent">
	
		Roll number : <input type="text" name="rollnumber" value="<%= s.getRollNumber() %>"> <br>
		First Name : <input type="text" name="firstname" value="<%= s.getFirstName() %>"> <br>
		Last Name : <input type="text" name="lastname" value="<%= s.getLastName() %>"> <br>
		
		<input type="submit" value="Update Student">
	
	</form>

</body>
</html>