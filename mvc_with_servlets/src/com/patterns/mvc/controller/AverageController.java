package com.patterns.mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.patterns.mvc.model.AverageModel;

//Controller
//to create servlet: src->new->other->servlet->add mapping
//to run the application: application->run as->run on server
//http://localhost:8080/mvc_with_servlets/numbers.html
/**
 * Servlet implementation class AverageController
 */
@WebServlet("/averageController")
public class AverageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*    
	*//**
		 * @see HttpServlet#HttpServlet()
		 */
	/*
	 * public AverageController() { super(); // TODO Auto-generated constructor stub
	 * }
	 * 
	 *//**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 *//*
			 * protected void doGet(HttpServletRequest request, HttpServletResponse
			 * response) throws ServletException, IOException { // TODO Auto-generated
			 * method stub
			 * response.getWriter().append("Served at: ").append(request.getContextPath());
			 * }
			 */

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		
		AverageModel model = new AverageModel();
		int result = model.calculateAverage(num1, num2);
		
		request.setAttribute("result", result);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
		requestDispatcher.forward(request, response);
	}

}
