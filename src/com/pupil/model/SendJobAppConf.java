package com.pupil.model;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

public class SendJobAppConf implements Runnable  {
	
	private HttpServletRequest req;	
	private String emailId;
	private Map<String,String[]> mapParameters;
	
public SendJobAppConf(HttpServletRequest request, String email,Map<String,String[]> mapParam){			
		req=request;	
		emailId=email;
		mapParameters=mapParam;
}

@Override
public void run() {		
	sendJobApplicationConfirmation();
}

public void sendJobApplicationConfirmation(){
	String from = "csjobsleads@aggiemail.usu.edu";
	int job_uid=Integer.parseInt(mapParameters.get("id")[0]);
	String subject = "Thanks for applying Job ID:"  + job_uid + "";
	//String jobDescription = req.getParameter("job_description");
	String url="https://localhost:8443/pupil/viewjobindetail.do?id=";
	
	 String message = "<table><tr><td>Thanks for applying Job ID:" + job_uid + "</td><td></td></tr><br>" +
	    		"<br>" +
	    				"<a href=" + url + job_uid + ">Click Here to view the job</a><br><br><tr><td></td><td>Note: Please do not reply to this automated e-mail</td></tr></table> " ;
	 
	 String to = emailId;
		SendMail sendMail = new SendMail(from, to, subject, message);
     sendMail.send();
      	
}

}
