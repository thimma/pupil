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
import com.pupil.model.CreateAccountModel;

/**
 * Servlet implementation class CreateAccountInDb
 */
@WebServlet("/CreateAccountInDb")
public class CreateAccountInDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountInDb() {
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
		response.setContentType("text/html");
		CreateAccountModel createAccount = new CreateAccountModel();
		createAccount.createAccount(request, response,(Connection)getServletContext().getAttribute("conn"));
		
		//create session
		HttpSession session = request.getSession();
		session.setAttribute("emailId", request.getParameter("EMAIL_ID"));
		session.setAttribute("userGroup", request.getParameter("USER_GROUP_CD"));
		//session.setAttribute("aNumber", request.getParameter("ANUMBER"));
		
		RequestDispatcher view;
		
		//navigate to home page based on user group
		
		if(request.getParameter("USER_GROUP_CD").equals("student")){
			view = request.getRequestDispatcher("homepagestudent.jsp");
			view.forward(request, response);
		}else if(request.getParameter("USER_GROUP_CD").equals("faculty")){
			view=request.getRequestDispatcher("homepagefaculty.jsp");
			view.forward(request, response);
		}else if(request.getParameter("USER_GROUP_CD").equals("admin")){
			
		}else{
			
		}
		
		
		
		
	}

}
