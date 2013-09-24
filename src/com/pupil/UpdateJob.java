package com.pupil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.pupil.model.CreateJobInDbModel;
import com.pupil.model.SendEmailOnJobCreation;

/**
 * Servlet implementation class UpdateJob
 */
@WebServlet("/UpdateJob")
public class UpdateJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		CreateJobInDbModel createJobDb= new CreateJobInDbModel();
		createJobDb.createJobInDatabase(request, response, (Connection)getServletContext().getAttribute("conn"));
		
		Map<String,String[]> mapParameters =  new HashMap<String,String[]>();
		mapParameters.putAll(request.getParameterMap());
		if(request.getParameter("send_email").equals("Y")){
		
		Thread t = new Thread(new SendEmailOnJobCreation(mapParameters, response, (Connection)getServletContext().getAttribute("conn")));
		t.start();
		}
		
		String message = "Job details updated successfully";
		session.setAttribute("message", message);
		
		RequestDispatcher view = request.getRequestDispatcher("homepagefaculty.jsp");		
		view.forward(request, response);
	}

}
