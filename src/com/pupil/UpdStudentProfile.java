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

/**
 * Servlet implementation class UpdStudentProfile
 */
@WebServlet("/UpdStudentProfile")
public class UpdStudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdStudentProfile() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		UpdStudentProfileInDb updateStudProf = new UpdStudentProfileInDb();
		updateStudProf.getStudentAnumber(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		updateStudProf.uploadTest(request, response, (Connection)getServletContext().getAttribute("conn"));
		updateStudProf.updateStudentContactDetails(request, response, (Connection)getServletContext().getAttribute("conn"));
		updateStudProf.updateStudentCurrentProgram(request, response, (Connection)getServletContext().getAttribute("conn"));
		updateStudProf.updateStudentResume(request, response, (Connection)getServletContext().getAttribute("conn"));
		System.out.println();
		
		RequestDispatcher view = request.getRequestDispatcher("homepagestudent.jsp");
		
		view.forward(request, response);
	}

}
