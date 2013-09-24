package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetEmployers {
	
	public HashMap<String, String> getEmployers(HttpServletRequest request, HttpServletResponse response, Connection con){
		
		//ArrayList<String> employers = new ArrayList<String>();
		HashMap<String, String> employers = new HashMap<String, String>();
		
		String query = "SELECT * FROM employers";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) con.prepareStatement(query);			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				employers.put(rs.getString(1), rs.getString(2));								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employers;
	}
	
}
