package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.java.DAO.ClassDAOImpl;
import com.java.DAO.StudentDAOImpl;
import com.java.persistence.Class;
import com.java.persistence.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addNewClass
 */
@WebServlet("/addNewClass")
public class addNewClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addNewClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		String className = request.getParameter("className");
		
		Class Class = new Class();
		

		Class.setClassName(className);
		try {
			int status = new ClassDAOImpl().addClass(Class);
			if(status>0){  
				pw.println("<h1>Class successfully added!</h1>");
				request.getRequestDispatcher("index.jsp").include(request, response);  
			}else{  
				pw.println("<h1>Sorry! unable to save record<h1>");  
				request.getRequestDispatcher("index.jsp").include(request, response);  
			} 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			pw.println("<h1>SQL Exception</h1>");
			e.printStackTrace();
		}
	}

}
