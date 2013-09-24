package com.pupil;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.pupil.model.GetEmployers;
import com.pupil.model.GetInDetailJob;
import com.pupil.model.Job;

/**
 * Servlet implementation class EditJob
 */
@WebServlet("/EditJob")
public class EditJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		GetInDetailJob jobInDetail = new GetInDetailJob();
		Job detailJob = jobInDetail.getIndetailJob(request, response, (Connection)getServletContext().getAttribute("conn"));
		request.setAttribute("detailJob", detailJob);
		
		GetEmployers getEmp = new GetEmployers();
		HashMap<String, String> employers = getEmp.getEmployers(request, response, (Connection)getServletContext().getAttribute("conn"));
		request.setAttribute("employers", employers);
		
		RequestDispatcher view;
		
		view = request.getRequestDispatcher("editjob.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
