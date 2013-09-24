package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CreateNewEmployerModel {
	
	public void createNewEmployer(HttpServletRequest request, HttpServletResponse response, Connection con){
		PreparedStatement stmt;
		ResultSet rs;
		
		String query= "SELECT employer_id FROM employers WHERE employer_id=?";
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, request.getParameter("employer_id"));
			rs = stmt.executeQuery();
			if(rs.next()){
				
			}else{
				query="INSERT INTO employers (employer_id,employer_name) VALUES (?,?)";
				stmt = (PreparedStatement) con.prepareStatement(query);
				stmt.setString(1, request.getParameter("employer_id"));
				stmt.setString(2, request.getParameter("employer_name"));
				stmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
