package com.jspCRUD.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspCRUD.bean.StudentInfo;
import com.jspCRUD.dao.StudentDao;

/**
 * Servlet implementation class UpdateStudent
 */
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rollnuber= Integer.parseInt( request.getParameter("rollnumber"));
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
	
		StudentInfo studinfo=new StudentInfo(rollnuber, firstname, lastname);
		
		StudentDao dao=new StudentDao();
		
		try {
			boolean rowupdated=dao.updateStudent(studinfo);
			
			if(rowupdated) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("AddStudent.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
