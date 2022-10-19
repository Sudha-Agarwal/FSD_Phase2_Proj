package com.java.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistence.Class;
import com.java.persistence.Subject;
import com.java.persistence.Teacher;

import hibernateUtil.HibernateUtil;

public class AssignTeacherAndSubjectToClassDAO {SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
Session sessionObj;

@SuppressWarnings("finally")
public int addTeacherAndSubjectToClass(Class Class1, int teacherId, int subjectId) {
	try {	
		sessionObj = sessionFactoryObj.openSession();
		sessionObj.getTransaction().begin();
		Teacher teacher= new Teacher();
		teacher = new TeacherDAOImpl().getTeacher(teacherId);
		
		System.out.println(teacher.getTeacherId());
		
		Subject subject = new Subject();
		subject = new SubjectDAOImpl().getSubject(subjectId);

		Class1.getTeachers().add(teacher);
		Class1.getSubjects().add(subject);
		
		Query q=sessionObj.createQuery("from Teacher where teacher_id=:i");  
		
		//sessionFactoryObj.getCurrentSession().createQuery("select*  FROM department WHERE id = "+id).executeUpdate();
		//sessionObj.update(Class1);			
		//sessionObj.getTransaction().commit();
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