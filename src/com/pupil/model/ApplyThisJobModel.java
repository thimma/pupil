package com.pupil.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ApplyThisJobModel {
	
	private boolean resumeFromProfile=false;
	private InputStream resume;
	private java.sql.Blob resumeBlob;
	private String coverLetter;
	private long size;
	private String aNumber;
	
	public void setAppltThisJobParameters(HttpServletRequest request, HttpServletResponse response, String emailId, Connection con){
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		String contextRoot = request.getServletContext().getRealPath("/");
		
		// Set factory constraints
		factory.setSizeThreshold(10000000);
		factory.setRepository(new File(contextRoot + "WEB-INF\tmp"));
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(1000000);
		
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			
			while(iter.hasNext()){
				FileItem item = iter.next();
				if (item.isFormField()) {
				    String name = item.getFieldName();				    
				    switch (name) {
					case "useprofile":
						if(item.getString().equals("Y"))
							resumeFromProfile=true;							
						break;
					case "COVER_LETTER":
						coverLetter=item.getString();
						break;
					default:
						break;
					
				    }
				}else{
					 try {
						 if(resumeFromProfile){
							 
							 String query ="SELECT student_resume.RESUME FROM student_resume,account_details WHERE student_resume.ANUMBER=account_details.ANUMBER AND account_details.EMAIL_ID=?";								
							 PreparedStatement stmt;								
								try {
									stmt = (PreparedStatement) con.prepareStatement(query);
									stmt.setString(1, emailId);
									ResultSet rs = stmt.executeQuery();
									
									while(rs.next()){
										resumeBlob=rs.getBlob(1);										
										break;
									}
								} catch (SQLException e) {								
									e.printStackTrace();
								}
						 }else{
							 resume = item.getInputStream();
							 size=item.getSize();
						}
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void applyToThisJob(HttpServletRequest request, HttpServletResponse response, String aNum, Connection con){
		
		
		PreparedStatement stmt;
		ResultSet rs;
		String query;
		if (resumeFromProfile) {
			query = "SELECT RESUME FROM student_resume WHERE ANUMBER=?";
			try {
				stmt = (PreparedStatement) con.prepareStatement(query);
				stmt.setString(1, aNum);
				rs = stmt.executeQuery();
				if (rs.next()) {
					
					resumeBlob=rs.getBlob(1);
					query = "INSERT INTO jobs_applied (RESUME,COVER_LETTER,ANUMBER,job_uid) VALUES (?,?,?,?)";
					//query = "INSERT INTO student_resume (RESUME,COVER_LETTER,ANUMBER) VALUES (?,?,?)";
					
						try {
							stmt = (PreparedStatement) con.prepareStatement(query);
							// stmt.setBytes(1, resume);
							stmt.setBlob(1, resumeBlob);
							//stmt.setBlob(1, resume);
							stmt.setString(2, coverLetter);
							// stmt.setBytes(2, coverLetter.getBytes());
							stmt.setString(3, aNum);
							stmt.setInt(4,Integer.parseInt(request.getParameter("id")));
							stmt.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				} else {
					//throw error
					//query = "INSERT INTO student_resume (RESUME,COVER_LETTER,ANUMBER) VALUES (?,?,?)";

				}
				

				// stmt.set
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}else{
			query = "INSERT INTO jobs_applied (RESUME,COVER_LETTER,ANUMBER,job_uid) VALUES (?,?,?,?)";
			//query = "INSERT INTO student_resume (RESUME,COVER_LETTER,ANUMBER) VALUES (?,?,?)";
			
				try {
					stmt = (PreparedStatement) con.prepareStatement(query);
					// stmt.setBytes(1, resume);
					//stmt.setBlob(1, resumeBlob);
					stmt.setBlob(1, resume);
					stmt.setString(2, coverLetter);
					// stmt.setBytes(2, coverLetter.getBytes());
					stmt.setString(3, aNum);
					stmt.setInt(4,Integer.parseInt(request.getParameter("id")));
					stmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}


