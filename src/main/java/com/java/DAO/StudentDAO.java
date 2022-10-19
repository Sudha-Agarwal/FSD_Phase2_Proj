package com.java.DAO;

import java.util.List;

import com.java.persistence.Student;

public interface StudentDAO {
	
	public int addStudent(Student employee);
	 
	 public List<Student> getStudent();
	 
	 public Student getStudent(int id);
	 
	 public void deleteStudent(int id);


}
