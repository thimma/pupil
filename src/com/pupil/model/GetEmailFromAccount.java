package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetEmailFromAccount {
	
	public String getEmailFromAccount(HttpServletRequest request, HttpServletResponse response, Connection con){
		String query = "SELECT EMAIL_ID FROM account_details WHERE ACCOUNT_ID=?";
		String email_id=null;
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, request.getParameter("acctid"));
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				email_id=rs.getString(1);
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email_id;
		
	}

}
