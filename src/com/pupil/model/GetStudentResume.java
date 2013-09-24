package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetStudentResume {
	
	public StudentResumeDetails getStudentResume(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		

		String query ="SELECT * FROM student_resume,account_details WHERE student_resume.ANUMBER=account_details.ANUMBER AND account_details.EMAIL_ID=?";
		StudentResumeDetails stResDet = new StudentResumeDetails();
		PreparedStatement stmt;
		
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				stResDet.setANumber(rs.getString(1));
				stResDet.setResume(rs.getBytes(2));
				stResDet.setCoverLetter(rs.getString(3));
				//request.setAttribute("studentResumeDetails", stResDet);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stResDet;
	
	}
}
