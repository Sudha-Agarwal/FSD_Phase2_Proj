package com.java.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistence.Class;
import com.java.persistence.Teacher;

import hibernateUtil.HibernateUtil;


public class TeacherDAOImpl implements TeacherDAO{
	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;

	@SuppressWarnings("finally")
	@Override
	public int addTeacher(Teacher teacher) {
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(teacher);
			sessionObj.getTransaction().commit();
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
				return 0;
			}
		}
		finally {
			sessionObj.close();
			return 1;
		}
	}

	@Override
	public List<Teacher> getTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher getTeacher(int teacherId) {
		Teacher list = null;
		try {
		sessionObj = sessionFactoryObj.openSession();
		sessionObj.getTransaction().begin();	
		Query q=sessionObj.createQuery("from Teacher where teacher_id=:i");  
		q.setParameter("i",teacherId);  
		list=(Teacher) q.uniqueResult();
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();				
			}				
		}
		finally {
			sessionObj.close();	
		}
		return list;
		//return sessionObj.createQuery("select *  FROM teacher WHERE teacher_id = "+teacherId).executeUpdate();
		//Teacher teacher =  (Teacher) sessionObj.get(Teacher.class, teacherId);
		//sessionObj.getTransaction().commit();
		//return teacher;
		
		/*
		 * sessionObj = sessionFactoryObj.getCurrentSession();
		 * sessionObj.getTransaction().begin(); //sessionFactoryObj.getCurrentSession().
		 * createQuery("select*  FROM department WHERE id = "+id).executeUpdate();
		 * Meeting meeting = (Meeting) sessionObj.get(Meeting.class, id);
		 * sessionObj.getTransaction().commit(); return meeting;
		 */
				
	}

	@Override
	public void deleteTeacher(int id) {
		// TODO Auto-generated method stub
		
	}

}
