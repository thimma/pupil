package com.pupil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UpdStudentProfileInDb {
	
	 private String aNumber;
	 private String firstName;
	 private String lastName;
	 private String address;
	 private String phoneNumber;
	 private String mobileNumber;
	 private String city;
	 private String state;
	 private int zip;
	 private String country;
	 
		private String currentProgram;
		private String level;
		private String expectedGradDate;
		private String college;
		private String campus;
		private String major;
		private String department;
		
		private InputStream resume;
		private String coverLetter;
		private long size;
	
	 public void getStudentAnumber(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		
		String query= "SELECT * FROM account_details WHERE EMAIL_ID=?";
		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			rs = stmt.executeQuery();
			if(rs.next()){
				aNumber=rs.getString(6);				
			}
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}
	}
	
	
	public void updateStudentContactDetails(HttpServletRequest request, HttpServletResponse response, Connection con){
		
		PreparedStatement stmt;
		ResultSet rs;		
		String query= "SELECT * FROM student_contact WHERE ANUMBER=?";
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, aNumber);
			rs = stmt.executeQuery();
			if(rs.next()){
				query = "UPDATE student_contact SET ADDRESS=?, PHONE_NUMBER=?, MOBILE_NUMBER=?,CITY=?,STATE=?,ZIP=?,COUNTRY=?WHERE ANUMBER=?";	
			}else{
				query="INSERT INTO student_contact (ADDRESS,PHONE_NUMBER,MOBILE_NUMBER,CITY,STATE,ZIP,COUNTRY,ANUMBER) VALUES (?,?,?,?,?,?,?,?)";
		
			}
			
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, address);
			stmt.setString(2, phoneNumber);
			stmt.setString(3, mobileNumber);
			stmt.setString(4, city);
			stmt.setString(5, state);
			stmt.setInt(6, zip);
			stmt.setString(7, country);
			stmt.setString(8, aNumber);
			stmt.executeUpdate();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateStudentCurrentProgram(HttpServletRequest request, HttpServletResponse response, Connection con){		
	
		
		PreparedStatement stmt;
		ResultSet rs;		
		String query= "SELECT * FROM student_current_program WHERE ANUMBER=?";
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, aNumber);
			rs = stmt.executeQuery();
			if(rs.next()){
				query = "UPDATE student_current_program SET CURRENT_PROGRAM=?, LEVEL=?, EXPECTED_GRAD_DATE=?,COLLEGE=?,CAMPUS=?,MAJOR=?,DEPARTMENT=? WHERE ANUMBER=?";
				
			}else{
				query="INSERT INTO student_current_program (CURRENT_PROGRAM,LEVEL,EXPECTED_GRAD_DATE,COLLEGE,CAMPUS,MAJOR,DEPARTMENT,ANUMBER) VALUES (?,?,?,?,?,?,?,?)";									
				
			}
			
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, currentProgram);
			stmt.setString(2, level);
			
			String s = expectedGradDate;
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d=null;
			try {
				d = df.parse(s);
			} catch (ParseException e) {			
				e.printStackTrace();
			}
			java.sql.Date date = new java.sql.Date(d.getTime());
			stmt.setDate(3, date);
			stmt.setString(4, college);
			stmt.setString(5, campus);
			stmt.setString(6, major);
			stmt.setString(7, department);
			stmt.setString(8, aNumber);
			stmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}				
	}
	
	public void updateStudentResume(HttpServletRequest request, HttpServletResponse response, Connection con){
		PreparedStatement stmt;
		ResultSet rs;		
		String query= "SELECT * FROM student_resume WHERE ANUMBER=?";
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, aNumber);
			rs = stmt.executeQuery();
			if(rs.next()){
				query = "UPDATE student_resume SET RESUME=?, COVER_LETTER=? WHERE ANUMBER=?";
				
			}else{
				query="INSERT INTO student_resume (RESUME,COVER_LETTER,ANUMBER) VALUES (?,?,?)";									
				
			}
		try {
			try {
				stmt = (PreparedStatement) con.prepareStatement(query);
				//stmt.setBytes(1, resume);
				stmt.setBlob(1, resume);
				stmt.setString(2, coverLetter);
				//stmt.setBytes(2, coverLetter.getBytes());
				stmt.setString(3, aNumber);
				stmt.executeUpdate();
				System.out.println();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//stmt.set
	  }catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void uploadTest(HttpServletRequest request, HttpServletResponse response, Connection con){
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		String contextRoot = request.getServletContext().getRealPath("/");
		
		// Set factory constraints
		factory.setSizeThreshold(10000000);
		factory.setRepository(new File(contextRoot + "WEB-INF\tmp"));
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(1000000);

		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			
			while(iter.hasNext()){
				FileItem item = iter.next();
				if (item.isFormField()) {
				    String name = item.getFieldName();				    
				    switch (name) {
					case "FIRST_NAME":
						firstName=item.getString();							
						break;
					case "LAST_NAME":
						lastName=item.getString();
						break;
					case "ADDRESS":
						address=item.getString();;
						break;
					case "PHONE_NUMBER":
						phoneNumber=item.getString();
						break;
					case "MOBILE_NUMBER":
						mobileNumber=item.getString();
						break;
					case "CITY":
						city=item.getString();
						break;
					case "STATE":
						state=item.getString();
						break;
					case "ZIP":
						zip=Integer.parseInt(item.getString());
						break;
					case "COUNTRY":
						country=item.getString();
						break;
					case "CURRENT_PROGRAM":
						currentProgram=item.getString();
						break;
					case "LEVEL":
						level=item.getString();
						break;
					case "EXPECTED_GRAD_DATE":
						expectedGradDate=item.getString();
						break;
					case "COLLEGE":
						college=item.getString();
						break;
					case "CAMPUS":
						campus=item.getString();
						break;
					case "MAJOR":
						major=item.getString();
						break;
					case "DEPARTMENT":
						department=item.getString();
						break;
					case "COVER_LETTER":
						coverLetter=item.getString();
						break;
					default:
						break;
					}
				    
				}else{
					 try {
						resume = item.getInputStream();
						size=item.getSize();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
