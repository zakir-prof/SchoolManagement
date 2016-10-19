package com.accolite.school.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.school.model.Student;

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

	@Transactional
	public void addStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(student);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Student> listStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentsList = session.createQuery("from Student").list();
		for(Student p : studentsList){
			System.out.println("Student List::"+p);
		}
		return studentsList;
	}

	@Transactional
	public void updateStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(student);
	}

	@Transactional
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Student student = (Student) session.load(Student.class, new Integer(id));
		return student;
	}

	@Transactional
	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student p = (Student) session.load(Student.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		
	}

}
