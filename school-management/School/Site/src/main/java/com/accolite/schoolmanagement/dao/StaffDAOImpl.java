package com.accolite.schoolmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.accolite.schoolmanagement.model.Student;

public class StaffDAOImpl implements StaffDAO{

private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    public StaffDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public StaffDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	/*public void addStaff(Staff staff) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(staff);
		tx.commit();
		session.close();
	}

	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<Staff> staffList = session.createQuery("from Staff").list();
		session.close();
		return staffList;
	}*/

}
