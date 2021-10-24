package com.jspCRUD.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspCRUD.dao.StudentDao;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rollnumber= Integer.parseInt(request.getParameter("rollnumber"));
		
		StudentDao dao=new StudentDao();
		
		try {
			boolean rowDeleted=dao.deleteStudent(rollnumber);
			if(rowDeleted) {
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
