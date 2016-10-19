package com.accolite.schoolmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.accolite.schoolmanagement.model.Student;

public class StudentDAOImpl implements StudentDAO {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public StudentDAOImpl(){
		
	}
	
	public StudentDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void save(Student student) {
		// TODO Auto-generated method stub
		    Configuration configuration = new Configuration().configure();
	        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
	        registry.applySettings(configuration.getProperties());
	        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
	         
	        // builds a session factory from the service registry
	        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(student);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		Session session = (new Configuration()).configure().buildSessionFactory().openSession();
		List<Student> studentList = session.createQuery("from Student").list();
		session.close();
		return studentList;
	
	}

}
