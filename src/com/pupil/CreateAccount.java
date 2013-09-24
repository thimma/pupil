package com.pupil;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.pupil.model.AuthenticateUser;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("signupform.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Logger logger = Logger.getLogger("myLogger");

		//logger.log(Level.SEVERE, "Hello logging");
		
		response.setContentType("text/html");
		RequestDispatcher view;
		
		if(request.getParameter("submitButton").equals("Sign-up")){
			
			view = request.getRequestDispatcher("signupform.jsp");
			view.forward(request, response);
		}else{
			
			String errorMessage;
			
			//authenticate user
			AuthenticateUser auth = new AuthenticateUser(); 
			if(auth.checkIfUserExists(request, response, request.getParameter("EMAIL_ID"), (Connection)getServletContext().getAttribute("conn"))){
				if(auth.authenticate(request, response, request.getParameter("EMAIL_ID"), (Connection)getServletContext().getAttribute("conn"))){
					String userGroup = auth.getUserGroup(request, response, request.getParameter("EMAIL_ID"), (Connection)getServletContext().getAttribute("conn"));
					
					//create session
					HttpSession session = request.getSession();
					session.setAttribute("emailId", request.getParameter("EMAIL_ID"));
					session.setAttribute("userGroup", userGroup);
					
					if(userGroup.equals("student")){
						view = request.getRequestDispatcher("homepagestudent.jsp");
						view.forward(request, response);
					}else if(userGroup.equals("faculty")){
						view=request.getRequestDispatcher("homepagefaculty.jsp");
						view.forward(request, response);
					}else if(userGroup.equals("admin")){
						
					}else{
						
					}
				}else{
					errorMessage="User ID or password is incorrect,please enter correct user id/password";
					request.setAttribute("errorMessage",errorMessage);
					view=request.getRequestDispatcher("LoginError.jsp");
					view.forward(request, response);
				}
			}else{
				errorMessage="User ID does not exist please sign-up";
				request.setAttribute("errorMessage",errorMessage);
				view=request.getRequestDispatcher("LoginError.jsp");
				view.forward(request, response);
			}
			
		}
	}

}
