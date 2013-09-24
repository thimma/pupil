package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetJobApplicantsList {
	public ArrayList<StudentAccountDetails> getJobApplicantsList(HttpServletRequest request, HttpServletResponse response, Connection con){
		ArrayList<StudentAccountDetails> applicantsList = new ArrayList<StudentAccountDetails>();
		String query="SELECT actDetails.* FROM account_details actDetails,jobs_applied jobsApp WHERE actDetails.ANUMBER=jobsApp.ANUMBER AND jobsApp.job_uid=?";
		
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, request.getParameter("id"));
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				StudentAccountDetails stAcDet = new StudentAccountDetails();
				stAcDet.setAccountId(rs.getInt(1));
				stAcDet.setUserGroupCd(rs.getString(2));
				stAcDet.setFirstName(rs.getString(3));
				stAcDet.setLastName(rs.getString(4));
				stAcDet.setEmailId(rs.getString(5));
				stAcDet.setANumber(rs.getString(6));
				applicantsList.add(stAcDet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return applicantsList;
	}

}
