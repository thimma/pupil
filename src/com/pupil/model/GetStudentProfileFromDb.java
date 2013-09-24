package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetStudentProfileFromDb {

	public void getStudentAccountDetails(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		String query = "SELECT * FROM account_details WHERE EMAIL_ID=?";
		StudentAccountDetails stAcDet = new StudentAccountDetails();
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				stAcDet.setAccountId(rs.getInt(1));
				stAcDet.setUserGroupCd(rs.getString(2));
				stAcDet.setFirstName(rs.getString(3));
				stAcDet.setLastName(rs.getString(4));
				stAcDet.setEmailId(rs.getString(5));
				stAcDet.setANumber(rs.getString(6));
				request.setAttribute("studentAccountDetails", stAcDet);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getStudentContactDetails(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		String query = "SELECT * FROM student_contact,account_details WHERE student_contact.ANUMBER=account_details.ANUMBER AND account_details.EMAIL_ID=?";
		StudentContactDetails stCntctDet = new StudentContactDetails();
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				stCntctDet.setANumber(rs.getString(1));
				stCntctDet.setAddress(rs.getString(2));
				stCntctDet.setPhoneNumber(rs.getString(3));
				stCntctDet.setMobileNumber(rs.getString(4));
				stCntctDet.setCity(rs.getString(5));
				stCntctDet.setState(rs.getString(6));
				stCntctDet.setZip(rs.getInt(7));
				stCntctDet.setCountry(rs.getString(8));
				request.setAttribute("studentContactDetails", stCntctDet);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getStudentCurrentProgram(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		String query = "SELECT * FROM student_current_program,account_details WHERE student_current_program.ANUMBER=account_details.ANUMBER AND account_details.EMAIL_ID=?";
		StudentCurrentProgram stCurntProg = new StudentCurrentProgram();
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				stCurntProg.setANumber(rs.getString(1));
				stCurntProg.setCurrentProgram(rs.getString(2));
				stCurntProg.setLevel(rs.getString(3));
				stCurntProg.setExpectedGradDate(rs.getDate(4).toString());
				stCurntProg.setCollege(rs.getString(5));
				stCurntProg.setCampus(rs.getString(6));
				stCurntProg.setMajor(rs.getString(7));
				stCurntProg.setdepartment(rs.getString(8));
				request.setAttribute("studentCurrentProgramDetails", stCurntProg);
				break;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void getStudentResumeDetails(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
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
				request.setAttribute("studentResumeDetails", stResDet);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
