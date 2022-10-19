package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.java.DAO.SubjectDAOImpl;
import com.java.DAO.TeacherDAOImpl;
import com.java.persistence.Subject;
import com.java.persistence.Teacher;

/**
 * Servlet implementation class addNewSubject
 */
@WebServlet("/addNewSubject")
public class addNewSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addNewSubject() {
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

		String subjectName = request.getParameter("subjectName");

		Subject subject = new Subject();
		
		subject.setSubjectName(subjectName);
		try {
			int status = new SubjectDAOImpl().addSubject(subject);
			if(status>0){  
				pw.println("<h1>Subject successfully added!</h1>");
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
