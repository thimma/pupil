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
import com.pupil.model.GetApplicantsResume;
import com.pupil.model.GetEmailFromAccount;

/**
 * Servlet implementation class ApplicantsResume
 */
@WebServlet("/ApplicantsResume")
public class ApplicantsResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantsResume() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		GetApplicantsResume appsResume = new GetApplicantsResume();
		GetEmailFromAccount account = new GetEmailFromAccount();
		String email=account.getEmailFromAccount(request, response, (Connection)getServletContext().getAttribute("conn"));
		response.setContentType("Application/pdf");
		response.addHeader("content-disposition", "inline;filename=Resume.pdf");
		ServletOutputStream out = response.getOutputStream();
		out.write(appsResume.getApplicantsResume(request, response, email, (Connection)getServletContext().getAttribute("conn")));
		
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
