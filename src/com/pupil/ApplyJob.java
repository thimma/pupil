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
import com.pupil.model.GetInDetailJob;
import com.pupil.model.GetStudentProfileFromDb;
import com.pupil.model.Job;

/**
 * Servlet implementation class ApplyJob
 */
@WebServlet("/ApplyJob")
public class ApplyJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		GetStudentProfileFromDb studProfDb = new GetStudentProfileFromDb();
		studProfDb.getStudentContactDetails(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		studProfDb.getStudentResumeDetails(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		
		GetInDetailJob jobInDetail = new GetInDetailJob();
		Job detailJob = jobInDetail.getIndetailJob(request, response, (Connection)getServletContext().getAttribute("conn"));
		request.setAttribute("detailJob", detailJob);
		
		RequestDispatcher view = request.getRequestDispatcher("applytothisjob.jsp");
		
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
