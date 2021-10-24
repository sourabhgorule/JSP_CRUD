<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jspCRUD.dao.StudentDao"%>
<%@page import="com.jspCRUD.bean.StudentInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

		


</head>
<body>

<main>

<h1>Student Information</h1>
<br>
<hr>

<%
StudentDao dao=new StudentDao();
List <StudentInfo> students=dao.allStudent();




%>

<table border=1>
	
		<thead>
			<tr>
				<td>Roll Number</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Edit Info</td>
				<td>delete Info</td>
			</tr>
		</thead>
		<tbody>
		
		<%
		
			for(StudentInfo s : students){
				
				out.print("<tr>");
				out.print("<td> "+s.getRollNumber()+" </td>");
				out.print("<td> "+s.getFirstName()+" </td>");
				out.print("<td> "+s.getLastName()+" </td>");
				
				//created edit link
				String editLink="<a href='edit-student.jsp?rollnumber="+s.getRollNumber()+"'>Edit</a>";
				
				String deleteLink="<a href='DeleteServlet?rollnumber="+s.getRollNumber()+"'>delete</a>";
				out.print("<td>"+editLink+"</td>");
				out.print("<td>"+deleteLink+"</td>");
				
				out.print("</tr>");
			}
		
		%>
		</tbody>
		</table>

<a href="AddStudent.html">Add Student</a>

</main>
</body>
</html>