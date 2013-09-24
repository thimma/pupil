package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetInDetailJob {
	
	public Job getIndetailJob(HttpServletRequest request, HttpServletResponse response, Connection con){
		Job job = new Job();
		String query= "SELECT * FROM jobs_info WHERE job_uid=?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, request.getParameter("id"));
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){				
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
			}else{
				System.err.println("There is no job with this job ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return job;
	}
}
