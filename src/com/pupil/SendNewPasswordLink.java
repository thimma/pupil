package com.pupil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.pupil.model.AuthenticateUser;
import com.pupil.model.SendEmailForgotPassword;

/**
 * Servlet implementation class SendNewPasswordLink
 */
@WebServlet("/SendNewPasswordLink")
public class SendNewPasswordLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendNewPasswordLink() {
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
		response.setContentType("text/html");
		RequestDispatcher view;
		
		//validate email if exist send really,else just say that email is sent w/o sending
		
		//send email
		SendEmailForgotPassword sendEmail = new SendEmailForgotPassword(request, response, (Connection)getServletContext().getAttribute("conn"));
		sendEmail.sendEmailForgotPassword();
		
		String message;
		message="An E-Mail has been sent with necessary information";
			
		
		
		request.setAttribute("message",message);
		view=request.getRequestDispatcher("DisplayMessage.jsp");
		view.forward(request, response);
		
	}

}
