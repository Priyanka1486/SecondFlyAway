package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.dbconnection.*;

public class RegistrationServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		String firstName = request.getParameter("fname");
		String lastName  = request.getParameter("lname");
		String email =	request.getParameter("email");
		String password =request.getParameter("password");
		String confirmPassword = request.getParameter("confirmpassword");
		
		UserDetail user = new UserDetail(firstName,lastName,email,password);
		DBConnection conn = new DBConnection();
		if(conn != null) {
			boolean flag = conn.userRegistration(user);
			if(flag)
				response.sendRedirect("loginPage");
			else
				response.sendRedirect("registration.html");
		}  
	}

}
