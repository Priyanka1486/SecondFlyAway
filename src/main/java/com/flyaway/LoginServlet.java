package com.flyaway;

import com.dbconnection.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDetail user = null;
		DBConnection conn = new DBConnection();
		if(conn != null) {
			user = conn.userLoginCheck(email,password);
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("name", user.getFirstName());
				RequestDispatcher rd = request.getRequestDispatcher("dashboardPage");
				rd.forward(request, response);
			}else {
				response.sendRedirect("loginPage");
			}
		}      
	}
}
