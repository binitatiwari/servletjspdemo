package com.vastika.payroll.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GreetingsServlet")
public class GreetingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<h1>");
		out.println("Welcome to servlet programming.");
		out.println("<h1>");
		out.println("<h3>");
		out.println("<marquee>");
		out.println("Hello,Good Morning ");
		out.println("<br>");
		out.println("Good Afternoon ");
		out.println("<br>");		
		out.println("Good Evening");
		out.println("<marquee>");
		out.println("</h3>");
		
		
		
	}

	
	

}
