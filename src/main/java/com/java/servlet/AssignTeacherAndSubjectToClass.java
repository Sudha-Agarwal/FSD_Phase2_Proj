package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.java.DAO.AssignTeacherAndSubjectToClassDAO;
import com.java.DAO.ClassDAOImpl;
import com.java.persistence.Class;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AssignTeacherAndSubjectToClass
 */
@WebServlet("/AssignTeacherAndSubjectToClass")
public class AssignTeacherAndSubjectToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacherAndSubjectToClass() {
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

		int teacherId = Integer.valueOf(request.getParameter("teachers"));
		int classId = Integer.valueOf(request.getParameter("classes"));
		int subjectId = Integer.valueOf(request.getParameter("subjects"));
		
		Class Class= new Class();
		//Teacher teacher = new TeacherDAOImpl().getTeacher(teacherId);				
		Class = new ClassDAOImpl().getClasses(classId);		
		
		try {
			int status  = new AssignTeacherAndSubjectToClassDAO().addTeacherAndSubjectToClass(Class, teacherId, subjectId);
			if(status>0){  
				pw.println("<h1>Teacher and Subject assignedTo Class successfully!</h1>");
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
