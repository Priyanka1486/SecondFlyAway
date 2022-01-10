package com.flyaway;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dbconnection.DBConnection;

import java.io.*;

public class ConfirmationServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DBConnection conn = new DBConnection();
		if(conn != null) {
			boolean updateflag = false;
			HttpSession session = request.getSession(false);
			if(session != null) {
				String passenger_no= (String)session.getAttribute("passengers");
				int passengers = Integer.parseInt(passenger_no);
				String traveldate = (String)session.getAttribute("traveldate");
				String flight_no = (String)session.getAttribute("fid");
				int seat= (Integer)session.getAttribute("available_seat");
				seat = seat - passengers;
				System.out.println(passengers);
				System.out.println(flight_no);
				if(seat > 0)
					updateflag = conn.availableSeatUpdate(seat,flight_no,traveldate);
				if(updateflag) {
					RequestDispatcher rd = request.getRequestDispatcher("confirmationPage");
					rd.forward(request, response);
				}
			}else {
				response.sendRedirect("loginPage");
			}
		} 
	}   
}
