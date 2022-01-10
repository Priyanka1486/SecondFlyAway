package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import com.dbconnection.DBConnection;

import java.io.*;
import java.util.*;

public class DashboardServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException ,IOException {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String travelDate = request.getParameter("traveldate");
		String passengers = request.getParameter("passengers");	
		List flights = null;
		DBConnection con = new DBConnection();
		if(con != null) {
			flights = con.getAvailableFlights(source,destination,travelDate);
			if(flights != null && flights.isEmpty()== false) {
				HttpSession session = request.getSession(false);
				if(session!= null)
				{
					System.out.println("in flights");
					session.setAttribute("flights", flights);
					session.setAttribute("source", source);
					session.setAttribute("destination", destination);
					session.setAttribute("traveldate", travelDate);
					session.setAttribute("passengers", passengers);
					RequestDispatcher rd = request.getRequestDispatcher("searchResultPage");
					rd.forward(request, response);
				}else{
					response.sendRedirect("loginPage");
				}                   
			}
			else {
				System.out.println("No flight is there.");
				PrintWriter out = response.getWriter();
				out.println("<html><body><h1>No Flight is there for this route.</h1></body></html>");
			}
		}
   	}
}
