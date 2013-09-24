package com.pupil;

import java.io.IOException;
import java.util.ArrayList;
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
import com.pupil.model.GetJobsList;
import com.pupil.model.Job;

/**
 * Servlet implementation class GroupJobs
 */
@WebServlet("/GroupJobs")
public class GroupJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupJobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	
	GetEmployers getEmp = new GetEmployers();
	HashMap<String, String> employers = getEmp.getEmployers(request, response, (Connection)getServletContext().getAttribute("conn"));
	request.setAttribute("employers", employers);
	
	GetJobsList getJobsList = new GetJobsList();
	ArrayList<Job> jobsList = getJobsList.getFilteredJobs(request, response, (Connection)getServletContext().getAttribute("conn"));
	request.setAttribute("jobsList", jobsList);
	
	RequestDispatcher view;
	
	view = request.getRequestDispatcher("viewjobslist.jsp");
	view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
