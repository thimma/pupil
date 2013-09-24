package com.pupil.model;

import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SendEmailForgotPassword {
	
	HttpServletRequest req;
	HttpServletResponse resp;
	Connection connection;
	
	public SendEmailForgotPassword(HttpServletRequest request, HttpServletResponse response, Connection con){		
		
		req=request;
		resp=response;
		connection=con;
		
	}
	
	public void sendEmailForgotPassword(){
		
		String from = "csjobsleads@aggiemail.usu.edu";
		String subject = "Information for Forgot Password request";
		String url="https://localhost:8443/pupil/resetpassword.do?id=";
		UUID uuid = UUID.randomUUID();
		ByteBuffer bb = ByteBuffer.allocate(16);
		bb.putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits());
		
		
		String query = "INSERT INTO forgot_password (EMAIL_ID,UUID) VALUES (?,?)";
		PreparedStatement stmt;
		
		try {
			stmt = (PreparedStatement) connection.prepareStatement(query);
			stmt.setString(1, req.getParameter("EMAIL_ID"));
			stmt.setBytes(2, bb.array());			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message = "<table><tr><td>Hi,</td></tr><tr><td>Since you can't recollect your password, please reset your password with below link</td></tr>" +
				"<tr><td>" + "<a href=" + url  + uuid +">Click Here </a><br><br>Note: Please do not reply to this automated e-mail</table> " +  "</td></tr>";
		
		
		SendMail sendMail = new SendMail(from, req.getParameter("EMAIL_ID"), subject, message);
        sendMail.send();
		
	}

}
