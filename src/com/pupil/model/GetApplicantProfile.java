package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetApplicantProfile {

	public void getApplicantsCoverLetter(HttpServletRequest request, HttpServletResponse response, Connection con){
		String query = "SELECT COVER_LETTER FROM jobs_applied jobsApp, account_details acct WHERE jobsApp.ANUMBER=acct.ANUMBER AND acct.ACCOUNT_ID=? AND jobsApp.job_uid=?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, request.getParameter("acctid"));
			stmt.setString(2, request.getParameter("job_uid"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				request.setAttribute("coverLetter", rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
