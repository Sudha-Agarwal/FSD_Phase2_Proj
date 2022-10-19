package com.java.DAO;

import java.util.List;

import com.java.persistence.Class;

public interface ClassDAO {
	public int addClass(Class Class);
	 
	 public List<Class> getClasses();
	 
	 public Class getClasses(int classId);
	 
	 public void deleteClasses(int id);

}
