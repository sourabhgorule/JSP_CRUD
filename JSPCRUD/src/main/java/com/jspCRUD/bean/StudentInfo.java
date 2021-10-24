package com.jspCRUD.bean;

public class StudentInfo {
	
	private int rollNumber;
	private String firstName;
	private String lastName;
	
	
	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentInfo(int rollNumber, String firstName, String lastName) {
		super();
	
		
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	//System.out.println("in bean");	
	//	System.out.println("bean "+firstName);
	}


	public int getRollNumber() {
		return rollNumber;
	}


	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "StudentInfo [rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	

}
