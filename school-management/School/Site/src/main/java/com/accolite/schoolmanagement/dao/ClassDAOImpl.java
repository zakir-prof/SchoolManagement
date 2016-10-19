package com.accolite.schoolmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.accolite.schoolmanagement.model.Student;

public class ClassDAOImpl implements ClassDAO{

private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ClassDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public ClassDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public void addClasses(Class classs) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(classs);
		tx.commit();
		session.close();	
	}

	public List<Class> getAllClasses() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<Class> classList = session.createQuery("from Class").list();
		session.close();
		return classList;
	}

}
