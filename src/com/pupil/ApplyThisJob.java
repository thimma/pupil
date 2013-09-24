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
import com.pupil.model.ApplyThisJobModel;
import com.pupil.model.GetANumberFromEmail;
import com.pupil.model.SendEmailOnJobCreation;
import com.pupil.model.SendJobAppConf;

/**
 * Servlet implementation class ApplyThisJob
 */
@WebServlet("/ApplyThisJob")
public class ApplyThisJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyThisJob() {
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
		response.setContentType("text/html");
		
		ApplyThisJobModel applyThisJobModel = new ApplyThisJobModel();
		applyThisJobModel.setAppltThisJobParameters(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		
		GetANumberFromEmail getANumber = new GetANumberFromEmail();
		String aNum=getANumber.getStudentAnumber(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		applyThisJobModel.applyToThisJob(request, response, aNum, (Connection)getServletContext().getAttribute("conn"));
		
		Map<String,String[]> mapParameters =  new HashMap<String,String[]>();
		mapParameters.putAll(request.getParameterMap());
		Thread t = new Thread(new SendJobAppConf(request, (String)session.getAttribute("emailId"),mapParameters));
		t.start();
		
		RequestDispatcher view = request.getRequestDispatcher("homepagestudent.jsp");
		
		view.forward(request, response);

	}

}
