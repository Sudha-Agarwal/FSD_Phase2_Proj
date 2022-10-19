package com.java.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistence.Student;

import hibernateUtil.HibernateUtil;

public class StudentDAOImpl implements StudentDAO{

	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;

	@SuppressWarnings("finally")
	@Override
	public int addStudent(Student student) {
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(student);
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
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

	}

}
