package com.pupil.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ValidateEmail {
	
	public boolean validateEmail(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		String query = "SELECT * FROM login_credentials WHERE EMAIL_ID=? ";
		
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
}
