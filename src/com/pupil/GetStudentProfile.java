package com.pupil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.pupil.model.GetStudentProfileFromDb;

/**
 * Servlet implementation class GetStudentProfile
 */
@WebServlet("/GetStudentProfile")
public class GetStudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//session.getAttribute("emailId");
		
		GetStudentProfileFromDb studProfDb = new GetStudentProfileFromDb();
		
		studProfDb.getStudentAccountDetails(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		studProfDb.getStudentContactDetails(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		studProfDb.getStudentCurrentProgram(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		studProfDb.getStudentResumeDetails(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		//System.out.println(((StudentAccountDetails)request.getAttribute("studentAccountDetails")).getFirstName() + "test");
		RequestDispatcher view = request.getRequestDispatcher("updateStudentProfile.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
