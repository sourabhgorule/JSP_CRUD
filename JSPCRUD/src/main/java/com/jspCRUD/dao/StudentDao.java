package com.jspCRUD.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jspCRUD.bean.StudentInfo;

public class StudentDao {
	
	DB_Connection db=new DB_Connection();

	public List<StudentInfo> allStudent() throws SQLException{
		
		List<StudentInfo> studInfo=new ArrayList();
		
		String sql="select * from studentinfo";
		
		DB_Connection db=new DB_Connection();
		Connection con=db.getConnection();
	
		Statement statement=con.createStatement();
		
		ResultSet resultset=statement.executeQuery(sql);
		
		while(resultset.next()) {
			
			int rollnumber=resultset.getInt("rollnumber");
			String firstname=resultset.getString("firstname");
			String lastname=resultset.getString("lastname");
			
			StudentInfo studentinfo=new StudentInfo(rollnumber, firstname, lastname);
			
			studInfo.add(studentinfo);
			
			
		}
		
		resultset.close();
		statement.close();
		//System.out.println("dao");
		//System.out.println(studInfo);
		return studInfo;
	}
	
	public boolean addStudent(StudentInfo studinfo) throws SQLException {
		
		String sql="insert into studentinfo(rollnumber,firstname,lastname) values(?,?,?) ";
		
		DB_Connection db=new DB_Connection();
		Connection con=db.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1,studinfo.getRollNumber() );
		ps.setString(2, studinfo.getFirstName());
		ps.setString(3, studinfo.getLastName());
		
		boolean rowInserted=ps.executeUpdate()>0;
		
		ps.close();
		con.close();
		
		//System.out.println("in Dao");
		
		//System.out.println("dao"+rowInserted);
		//System.out.println(studinfo.getFirstName());
		
		//System.out.println(studinfo.getFirstName());
		return rowInserted;
		
		
	}

	public StudentInfo getRollNumber(int rnumber) throws SQLException {
		
		String sql="select * from studentinfo where rollnumber=?";
		Connection con= db.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, rnumber);
		
		ResultSet rs=ps.executeQuery();
		
		int rollnumber = 0;
		String firstname = null;
		String lastname = null;
		if(rs.next()) {
			 rollnumber=rs.getInt("rollnumber");
			 firstname=rs.getString("firstname");
			 lastname=rs.getString("lastname");
		}
		
		
		return new StudentInfo(rollnumber,firstname,lastname) ;
		
		
	}

	public boolean updateStudent(StudentInfo studinfo) throws SQLException {
		
		String sql="update studentinfo set firstname=? ,lastname=? where rollnumber=?";
		 boolean rowUpdated=false;
		Connection con=db.getConnection();
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1,studinfo.getFirstName() );;
		
		ps.setString(2, studinfo.getLastName());;
		
		ps.setInt(3, studinfo.getRollNumber());;
		
		
		rowUpdated=ps.executeUpdate()>0;
		
		ps.close();
		con.close();
		return rowUpdated;
		
		
	}

	public boolean deleteStudent(int rollnumber) throws SQLException {
		
		String sql="delete from studentinfo where rollnumber=?";
		
		Connection con=db.getConnection();
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, rollnumber);
		
		boolean rowdeleted=ps.executeUpdate()>0;
		
		return rowdeleted;
		
		
	}
	
}
