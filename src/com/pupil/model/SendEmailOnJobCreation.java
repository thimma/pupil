package com.pupil.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SendEmailOnJobCreation implements Runnable {
	
	Map<String,String[]> mapParameters;
	HttpServletResponse resp;
	Connection connection;
	
	public SendEmailOnJobCreation(Map<String,String[]> mapParam, HttpServletResponse response, Connection con){		
		
		mapParameters=mapParam;
		resp=response;
		connection=con;
		
	}
	
	@Override
	public void run() {		
		getEmailList();
	}
	
	public void getEmailList(){
		ArrayList<String> emailList = new ArrayList<String>();
		
		
		//emailList.add("thimmareddykalva@gmail.com");
		//emailList.add("thimmareddykalva@aggiemail.usu.edu");
		
		String from = "csjobsleads@aggiemail.usu.edu";
		String subject = "A new job has been posted";
	  
	    String job_uid=null;
	    
	    
	    
	    String query = "SELECT job_uid FROM jobs_info WHERE job_id=? AND employer_id=?";
	    PreparedStatement stmt;
	    
	    
	    
	    try {
			stmt = (PreparedStatement) connection.prepareStatement(query);			
			stmt.setString(1, mapParameters.get("job_id")[0]);
			stmt.setString(2, mapParameters.get("employer_id")[0]);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				job_uid=rs.getString(1);			
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
	    
	    String jobDescription = mapParameters.get("job_description")[0];
	    String jobLocation = mapParameters.get("job_location")[0];
	    String ptFt = mapParameters.get("parttime_fulltime")[0];
	    String jobSummary =mapParameters.get("job_summary")[0];
	    String url="https://localhost:8443/pupil/viewjobindetail.do?id=";
//	    
//	    message = " <table border='1'> <tr> <td colspan=2>" +
//	    		"<h1>jobDescription</h1>";
	    
	    query = "SELECT EMAIL_ID FROM account_details where EMAIL_ALERTS=?";
		try {
			stmt = (PreparedStatement) connection.prepareStatement(query);
			stmt.setString(1, "Y");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				emailList.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
	    
	    String message = "<table><tr><td></td><td>" + jobDescription + "</td></tr><br>" +
	    		"<tr><td>Job Location:</td> <td>" + jobLocation + "</td></tr><tr><td>Job Summary:</td><td>" +  jobSummary + "</td></tr><br>" +
	    				"<a href=" + url + Integer.parseInt(job_uid) + ">Click Here </a><br><br><tr><td></td><td>Note: Please do not reply to this automated e-mail</td></tr></table> " ;
	    
	    	
	    		
        		//"https://localhost:8443/pupil/viewjobindetail.do?id="+Integer.parseInt(job_uid) ;
	        
		Iterator it = emailList.listIterator();
		
		while(it.hasNext()){
			String to = (String)it.next();
			SendMail sendMail = new SendMail(from, to, subject, message);
	        sendMail.send();
		}
	}

}
