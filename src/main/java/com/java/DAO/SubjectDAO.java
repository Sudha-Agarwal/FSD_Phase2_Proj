package com.java.DAO;

import java.util.List;
import com.java.persistence.Subject;

public interface SubjectDAO {
	public int addSubject(Subject subject);
	 
	 public List<Subject> getSubject();
	 
	 public Subject getSubject(int subjectId);
	 
	 public void deleteSubject(int subjectId);

}
