package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AuthenticateUser {
	
	public boolean checkIfUserExists(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		String query = "SELECT * FROM login_credentials WHERE EMAIL_ID=?";
		
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	
	}
	
	public boolean authenticate(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		
		String query = "SELECT * FROM login_credentials WHERE EMAIL_ID=?";
		
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return request.getParameter("PASSWORD").equals(rs.getString(2));
			}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public String getUserGroup(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		
		String query = "SELECT * FROM account_details WHERE EMAIL_ID=?";
		
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return (rs.getString(2));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
