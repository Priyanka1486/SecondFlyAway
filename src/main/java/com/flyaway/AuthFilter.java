package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AuthFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain )
	throws ServletException, IOException{
		
		HttpServletRequest req  = (HttpServletRequest)request;
		HttpSession session = req.getSession(false);
		System.out.println("In am in filter");
		if(session != null) {
			chain.doFilter(request, response);
		}
		else {   
			HttpServletResponse res  = (HttpServletResponse)response;
			res.sendRedirect("loginPage");
		}
	}  
}
