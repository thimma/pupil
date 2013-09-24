package com.pupil.listener;

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try {			
			Connection con = (Connection)event.getServletContext().getAttribute("con");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext sc = event.getServletContext();
		String dburl = sc.getInitParameter("dburl");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		
		//String url = dburl + "?" + "user=" + user;
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("The url is " + dburl);
			Connection con = DriverManager.getConnection(dburl,user,password);
			//Connection con=DriverManager.getConnection(url);//DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_jobservices", "root", "root");
			sc.setAttribute("conn", con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		try {
//			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc.mysql://localhost:3306/student_jobservices", "root", "");
//			//Connection con=DriverManager.getConnection(url);
//			sc.setAttribute("conn", con);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
