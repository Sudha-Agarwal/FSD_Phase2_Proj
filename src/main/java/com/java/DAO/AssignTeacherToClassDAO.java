package com.java.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistence.Teacher;
import com.java.persistence.Class;

import hibernateUtil.HibernateUtil;

public class AssignTeacherToClassDAO {
	
	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;
	
	@SuppressWarnings("finally")
	public int addTeacherToClass(Class Class1, int teacherId) {
		try {	
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			Teacher teacher= new Teacher();
			teacher = new TeacherDAOImpl().getTeacher(teacherId);
			
			System.out.println(teacher.getTeacherId());

			Class1.getTeachers().add(teacher);
			
			sessionObj.update(Class1);			
			sessionObj.getTransaction().commit();
			return 1;
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				ex.printStackTrace();
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
				return 0;
			}
		}		
		finally {			
			sessionObj.close();
			
		}
		return 1;
	}

}
