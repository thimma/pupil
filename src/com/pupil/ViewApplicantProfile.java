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
import com.pupil.model.GetApplicantProfile;
import com.pupil.model.GetEmailFromAccount;
import com.pupil.model.GetStudentProfileFromDb;

/**
 * Servlet implementation class ViewApplicantProfile
 */
@WebServlet("/ViewApplicantProfile")
public class ViewApplicantProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewApplicantProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session.getAttribute("emailId");
		
		GetStudentProfileFromDb studProfDb = new GetStudentProfileFromDb();
		GetEmailFromAccount account = new GetEmailFromAccount();
		String email=account.getEmailFromAccount(request, response, (Connection)getServletContext().getAttribute("conn"));
		studProfDb.getStudentAccountDetails(request, response, email, (Connection)getServletContext().getAttribute("conn"));
		studProfDb.getStudentContactDetails(request, response, email, (Connection)getServletContext().getAttribute("conn"));
		
		GetApplicantProfile applicantProfile = new GetApplicantProfile();
		applicantProfile.getApplicantsCoverLetter(request, response, (Connection)getServletContext().getAttribute("conn"));
		request.setAttribute("job_uid", request.getParameter("job_uid"));
		RequestDispatcher view = request.getRequestDispatcher("viewApplicantDetailedProfile.jsp");
		//System.out.println();
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
