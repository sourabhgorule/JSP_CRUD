package com.jspCRUD.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspCRUD.bean.StudentInfo;
import com.jspCRUD.dao.DB_Connection;
import com.jspCRUD.dao.StudentDao;

/**
 * Servlet implementation class InsertInfo
 */
public class InsertInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int rollnumber= Integer.parseInt(request.getParameter("rollnumber"))  ;
		
		String firstname=request.getParameter("firstname");
		
		String lastname = request.getParameter("lastname");
		
		StudentInfo studinfo=new StudentInfo(rollnumber, firstname, lastname);
		
		System.out.println("in servlet");
		System.out.println("servlet "+studinfo.getFirstName());
		//System.out.println("servlet  "+firstname);
		
		StudentDao dao=new StudentDao();
		
		boolean rowInserted=false;
		
		try {
			 rowInserted=dao.addStudent(studinfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowInserted) {
			response.sendRedirect("index.jsp");
		}
		else {
			response.sendRedirect("AddStudent.html");
		}
		
		
	}

	

}
