package com.java.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistence.Class;

import hibernateUtil.HibernateUtil;


public class ClassDAOImpl implements ClassDAO{
	
	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;

	@SuppressWarnings("finally")
	@Override
	public int addClass(Class Class) {
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(Class);
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
	public List<Class> getClasses() {
		return null;
	}

	@Override
	public Class getClasses(int classId) {
		Class Class = null;
		try {
		sessionObj = sessionFactoryObj.getCurrentSession();
		sessionObj.getTransaction().begin();	
		
		Class =  (Class) sessionObj.get(Class.class, classId);
		sessionObj.getTransaction().commit();
		
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();				
			}			
		}
		finally {
			//sessionObj.close();			
		}
		return Class;
	}

	@Override
	public void deleteClasses(int id) {
		// TODO Auto-generated method stub
		
	}

}
