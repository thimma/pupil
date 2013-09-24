package com.pupil;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.pupil.model.GetJobApplicantsList;
import com.pupil.model.GetJobsList;
import com.pupil.model.Job;
import com.pupil.model.StudentAccountDetails;

/**
 * Servlet implementation class ViewJobApplicants
 */
@WebServlet("/ViewJobApplicants")
public class ViewJobApplicants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewJobApplicants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		GetJobApplicantsList jobAppLists = new GetJobApplicantsList();
		ArrayList<StudentAccountDetails> jobApplicantsList=jobAppLists.getJobApplicantsList(request, response, (Connection)getServletContext().getAttribute("conn"));
		request.setAttribute("jobApplicantsList", jobApplicantsList);
		request.setAttribute("job_uid", request.getParameter("id"));
		
		RequestDispatcher view;
		
		view = request.getRequestDispatcher("viewJobApplicantsList.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
