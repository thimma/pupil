package com.pupil.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CreateAccountModel {
	public void createAccount(HttpServletRequest request, HttpServletResponse response, Connection con){
		//Connection con = (Connection)request.getServletContext().getAttribute("conn");
		
		String userGrp = request.getParameter("USER_GROUP_CD");		
		String fName = request.getParameter("FIRST_NAME");
		String lName = request.getParameter("LAST_NAME");
		String emailId = request.getParameter("EMAIL_ID");
		String aNum = request.getParameter("ANUMBER");
		String password = request.getParameter("PASSWORD");
		
		String query="INSERT INTO account_details (USER_GROUP_CD,FIRST_NAME,LAST_NAME,EMAIL_ID,ANUMBER) " +
				"VALUES (?,?,?,?,?)";
		//NULL,'"+userGrp+"','"+fName+"','"+lName+"','"+emailId+"','"+aNum+"'
			
		try {
			//PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO account_details (USER_GROUP_CD,FIRST_NAME,LAST_NAME,EMAIL_ID,ANUMBER) VALUES ('"+userGrp+"','"+fName+"','"+lName+"','"+emailId+"','"+aNum+"')");
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, userGrp);
			stmt.setString(2, fName);
			stmt.setString(3, lName);
			stmt.setString(4, emailId);
			stmt.setString(5, aNum);
			stmt.executeUpdate();
			
			query="INSERT INTO login_credentials(EMAIL_ID,PASSWORD) " +
			"VALUES(?,?)";
			
			stmt = (PreparedStatement) con.prepareStatement(query);
			
			stmt.setString(1, emailId);
			stmt.setString(2, password);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
