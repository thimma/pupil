package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetANumberFromEmail {
	
public String getStudentAnumber(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		
	 	String aNumber=null;
		String query= "SELECT * FROM account_details WHERE EMAIL_ID=?";
		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, emailId);
			rs = stmt.executeQuery();
			if(rs.next()){
				aNumber=rs.getString(6);				
			}
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}
		
		return aNumber;
	}
}
