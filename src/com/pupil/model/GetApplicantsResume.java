package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetApplicantsResume {
	
	public byte[] getApplicantsResume(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		byte[] resume = null;
		String query = "SELECT RESUME FROM jobs_applied jobsApp, account_details acct WHERE jobsApp.ANUMBER=acct.ANUMBER AND acct.EMAIL_ID=? AND jobsApp.job_uid=?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			stmt.setString(2, request.getParameter("job_uid"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				resume=rs.getBytes(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resume; 
		
	}

}
