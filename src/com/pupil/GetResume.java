package com.pupil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.pupil.model.GetStudentProfileFromDb;
import com.pupil.model.GetStudentResume;
import com.pupil.model.StudentResumeDetails;

/**
 * Servlet implementation class GetResume
 */
@WebServlet("/GetResume")
public class GetResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetResume() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session.getAttribute("emailId");
		
		GetStudentResume studResume = new GetStudentResume();
		StudentResumeDetails stResDet = studResume.getStudentResume(request, response, (String)session.getAttribute("emailId"), (Connection)getServletContext().getAttribute("conn"));
		
		response.setContentType("Application/pdf");
		response.addHeader("content-disposition", "inline;filename=Resume.pdf");
		ServletOutputStream out = response.getOutputStream();
		out.write(stResDet.getResume());
		
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
