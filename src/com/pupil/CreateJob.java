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

/**
 * Servlet implementation class CreateJob
 */
@WebServlet("/CreateJob")
public class CreateJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		GetEmployers getEmp = new GetEmployers();
		HashMap<String, String> employers = getEmp.getEmployers(request, response, (Connection)getServletContext().getAttribute("conn"));
		request.setAttribute("employers", employers);
		
		RequestDispatcher view;
		
		view = request.getRequestDispatcher("createjob.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		GetEmployers getEmp = new GetEmployers();
		HashMap<String, String> employers = getEmp.getEmployers(request, response, (Connection)getServletContext().getAttribute("conn"));
		request.setAttribute("employers", employers);
		
		RequestDispatcher view;
		
		view = request.getRequestDispatcher("createjob.jsp");
		view.forward(request, response);
	}

}
