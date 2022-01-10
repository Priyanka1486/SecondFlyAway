package com.flyaway;

import java.util.regex.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

public class RegistrationFilter implements Filter {

	public void init(FilterConfig filterconfig) {
		
	}
	
	public boolean validationCheckForFields(String value,String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		if(matcher.matches()) 
			return true;
		return false;		
	}  
	
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain)
	throws ServletException, IOException {
		
		String firstName = request.getParameter("fname");
		String lastName  = request.getParameter("lname");
		String email =	request.getParameter("email");
		String password =request.getParameter("password");
		String confirmPassword = request.getParameter("confirmpassword");
		HttpServletResponse res = (HttpServletResponse)response;
		PrintWriter out = res.getWriter();
		System.out.println("I am in Registration Filter 1");
		if(((firstName != null) && (firstName.isEmpty()==false))&&
			((lastName != null) && (lastName.isEmpty()==false)) && 
			((email != null) && (email.isEmpty()==false)) &&
			((password != null) && (password.isEmpty()==false))&&
			((confirmPassword != null) && (confirmPassword.isEmpty()==false))){
			boolean proceedFlag = true;
			boolean flag = false;
			String regex;
			int option=1;
			System.out.println("I am in switch block");
			switch(option) {
				case 1:	regex = "[A-Z][a-z]*";
						flag = validationCheckForFields(firstName,regex);
						System.out.println("I am in first name");
						if(flag==false) {
							proceedFlag = false;
							System.out.println("I am in first name flag");
							break;
						}		
				case 2:	regex = "[A-Z][a-z]*";
						flag = validationCheckForFields(lastName,regex);
						System.out.println("I am in last name");
						if(flag==false) {
							proceedFlag = false;
							System.out.println("I am in last name flag");
							break;
						}						
			/*	case 3:	regex = "[A-Z][a-z]*";
							flag = validationCheckForFields(email,regex);
							if(flag==false) {
							proceedFlag = false;
							System.out.println("I am in email flag");
							break;
						}*/						
				case 4: regex = "^(?=.*[0-9])"
                       			+ "(?=.*[a-z])(?=.*[A-Z])"
                       			+ "(?=.*[@#$%^&+=])"
                       			+ "(?=\\S+$).{8,20}$";

						flag = validationCheckForFields(password,regex);
						if(flag==false) {
							proceedFlag = false;
							System.out.println("I am in first password flag");
							break;
						}	
							
				case 5:	regex = "^(?=.*[0-9])"
                       			+ "(?=.*[a-z])(?=.*[A-Z])"
                       			+ "(?=.*[@#$%^&+=])"
                       			+ "(?=\\S+$).{8,20}$";

						flag = validationCheckForFields(confirmPassword,regex);
						if(flag==false) {
							proceedFlag = false;
							System.out.println("I am in confirmed name flag");
							break;
						}						
			}
			System.out.println("proceed flag "+proceedFlag);
			if(proceedFlag) {
				if(password.equals(confirmPassword)) {
					System.out.println("I am in Registration Filter");
					chain.doFilter(request, response);
				}else {
					out.println("<h2>Password Mismatch</h2>");
					RequestDispatcher rd =  request.getRequestDispatcher("registrationPage");
					rd.include(request, response);
					
				}  
			}else {
				out.println("<h2>Please, enter valid values</h2>");
				RequestDispatcher rd =  request.getRequestDispatcher("registrationPage");
				rd.include(request, response);
				
			}		
		}else {  
		//	res.sendRedirect("registrationPage");
			out.println("<h2>Please, enter valid values</h2>");
			RequestDispatcher rd =  request.getRequestDispatcher("registrationPage");
			rd.include(request, response);
			
		} 
	}
}
