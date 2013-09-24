package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CreateJobInDbModel {

public void	createJobInDatabase(HttpServletRequest request, HttpServletResponse response, Connection con){
	
	PreparedStatement stmt;
	ResultSet rs;
	
	String query= "SELECT * FROM jobs_info WHERE job_uid=?";
	try {
		stmt = (PreparedStatement) con.prepareStatement(query);
		stmt.setString(1, request.getParameter("id"));
		rs = stmt.executeQuery();
		if(rs.next()){
			query="UPDATE jobs_info SET employer_id=?, job_description=?, job_creation_date=?, job_location=?, parttime_fulltime=?, job_summary=?, contact_person_name=?, contact_person_email=?, others=?, contact_person_phone=?, is_job_open=?, job_id=? WHERE job_uid=?";
			
			stmt = (PreparedStatement) con.prepareStatement(query);
			
			stmt.setString(1, request.getParameter("employer_id"));
			stmt.setString(2, request.getParameter("job_description"));
			String s = request.getParameter("job_creation_date");
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d=null;
			try {
				d = df.parse(s);
			} catch (ParseException e) {			
				e.printStackTrace();
			}
			java.sql.Date date = new java.sql.Date(d.getTime());
			stmt.setDate(3, date);
			stmt.setString(4, request.getParameter("job_location"));
			stmt.setString(5, request.getParameter("parttime_fulltime"));
			stmt.setString(6, request.getParameter("job_summary"));
			stmt.setString(7, request.getParameter("contact_person_name"));
			stmt.setString(8, request.getParameter("contact_person_email"));
			stmt.setString(9, request.getParameter("others"));
			stmt.setString(10, request.getParameter("contact_person_phone"));
			stmt.setString(11, request.getParameter("is_job_open"));
			stmt.setString(12, request.getParameter("job_id"));
			stmt.setString(13, request.getParameter("id"));
			stmt.executeUpdate();
			//query = "UPDATE student_contact SET ADDRESS=?, PHONE_NUMBER=?, MOBILE_NUMBER=?,CITY=?,STATE=?,ZIP=?,COUNTRY=?WHERE ANUMBER=?";	
		}else{
			query="INSERT INTO jobs_info (employer_id,job_description,job_creation_date,job_location,parttime_fulltime,job_summary,contact_person_name,contact_person_email,others,contact_person_phone,is_job_open,job_id)" +
					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//query="INSERT INTO student_contact (ADDRESS,PHONE_NUMBER,MOBILE_NUMBER,CITY,STATE,ZIP,COUNTRY,ANUMBER) VALUES (?,?,?,?,?,?,?,?)";	
		
		
		stmt = (PreparedStatement) con.prepareStatement(query);
		
		stmt.setString(1, request.getParameter("employer_id"));
		stmt.setString(2, request.getParameter("job_description"));
		String s = request.getParameter("job_creation_date");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d=null;
		try {
			d = df.parse(s);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		java.sql.Date date = new java.sql.Date(d.getTime());
		stmt.setDate(3, date);
		stmt.setString(4, request.getParameter("job_location"));
		stmt.setString(5, request.getParameter("parttime_fulltime"));
		stmt.setString(6, request.getParameter("job_summary"));
		stmt.setString(7, request.getParameter("contact_person_name"));
		stmt.setString(8, request.getParameter("contact_person_email"));
		stmt.setString(9, request.getParameter("others"));
		stmt.setString(10, request.getParameter("contact_person_phone"));
		stmt.setString(11, request.getParameter("is_job_open"));
		stmt.setString(12, request.getParameter("job_id"));		
		stmt.executeUpdate();
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}
}
