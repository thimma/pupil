package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetJobsList {
	
	public ArrayList<Job> getJobsList(HttpServletRequest request, HttpServletResponse response, Connection con){
		
		ArrayList<Job> jobsList = new ArrayList<Job>();
		String query= "SELECT * FROM jobs_info WHERE is_job_open=? ORDER BY UPDATE_TIME DESC";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, "Y");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Job job = new Job();
				
				job.setJob_uid(rs.getInt(1));
				job.setJob_id(rs.getString(2));
				job.setEmployer_id(rs.getString(3));
				job.setJob_description(rs.getString(4));
				job.setJob_creation_date(rs.getDate(5).toString());
				job.setJob_location(rs.getString(6));
				job.setParttime_fulltime(rs.getString(7));
				job.setJob_summary(rs.getString(8));
				job.setContact_person_name(rs.getString(9));
				job.setContact_person_email(rs.getString(10));
				job.setOthers(rs.getString(11));
				job.setContact_person_phone(rs.getString(12));
				job.setIs_job_open(rs.getString(13));
				jobsList.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobsList;
		
	}
	
	public ArrayList<Job> getFilteredJobs(HttpServletRequest request, HttpServletResponse response, Connection con){
		ArrayList<Job> jobsList = new ArrayList<Job>();
		String query="SELECT * FROM jobs_info WHERE employer_id=? AND is_job_open=? AND `job_creation_date` BETWEEN ? AND ? ORDER BY UPDATE_TIME DESC";
		
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, request.getParameter("employer_id"));
			stmt.setString(2, request.getParameter("is_job_open"));
			
			String s = request.getParameter("jobs_from_date");
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d=null;
			try {
				d = df.parse(s);
			} catch (ParseException e) {			
				e.printStackTrace();
			}
			java.sql.Date date = new java.sql.Date(d.getTime());
			stmt.setDate(3, date);
			
			s=request.getParameter("jobs_to_date");
			try {
				d = df.parse(s);
			} catch (ParseException e) {			
				e.printStackTrace();
			}
			date = new java.sql.Date(d.getTime());
			stmt.setDate(4, date);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Job job = new Job();
				
				job.setJob_uid(rs.getInt(1));
				job.setJob_id(rs.getString(2));
				job.setEmployer_id(rs.getString(3));
				job.setJob_description(rs.getString(4));
				job.setJob_creation_date(rs.getDate(5).toString());
				job.setJob_location(rs.getString(6));
				job.setParttime_fulltime(rs.getString(7));
				job.setJob_summary(rs.getString(8));
				job.setContact_person_name(rs.getString(9));
				job.setContact_person_email(rs.getString(10));
				job.setOthers(rs.getString(11));
				job.setContact_person_phone(rs.getString(12));
				job.setIs_job_open(rs.getString(13));
				jobsList.add(job);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobsList;
	}
}
