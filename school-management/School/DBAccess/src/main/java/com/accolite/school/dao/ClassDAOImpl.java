package com.accolite.school.dao;

import java.util.List;

import com.accolite.school.model.ClassSchedule;
import com.accolite.school.model.Classes;
import com.accolite.school.model.FeeTemplate;
import com.accolite.school.model.Result;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClassDAOImpl implements ClassDAO {

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

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Classes> getAllClasses() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Classes> classList = null;
		try {
			classList = (List<Classes>) session.createQuery("from Classes").list();
		} catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		}
		tx.commit();
		return classList;
	}

	@Transactional
	public Classes getClassById(int classId) {
		// TODO Auto-generated method stub
		Classes classs = null;
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			classs = (Classes) session.get(Classes.class, classId);
		} catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		}
		tx.commit();
		return classs;
	}

	@Transactional
	public void addClass(Classes classs) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(classs);
		tx.commit();

	}

	@Transactional
	public void addClassSchedule(ClassSchedule classSchedule) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(classSchedule);
		tx.commit();

	}

	@Transactional
	public void addFeeTemplate(FeeTemplate feeTemplate) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(feeTemplate);
		tx.commit();

	}

	@Transactional
	public void deleteClass(int classId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Classes classs = (Classes) session.get(Classes.class, classId);
			session.delete(classs);
		} catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		}
		tx.commit();
	}

	@Transactional
	public void deleteClassSchedule(int classScheduleId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			ClassSchedule classSchedule = (ClassSchedule) session.get(ClassSchedule.class, classScheduleId);
			session.delete(classSchedule);
		} catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		}
		tx.commit();
	}

	@Transactional
	public void deleteFeeTemplate(int FeeTemplateId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			FeeTemplate feeTemplate = (FeeTemplate) session.get(FeeTemplate.class, FeeTemplateId);
			session.delete(feeTemplate);
		} catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		}
		tx.commit();
	}

	@Transactional
	public void editClass(Classes updatedClass) {
		// TODO Auto-generated method stub
		ClassDAOImpl classDAOImpl = new ClassDAOImpl();
		classDAOImpl.deleteClass(updatedClass.getId());
		classDAOImpl.addClass(updatedClass);
	}

	@Transactional
	public void editClassSchedule(ClassSchedule updatedClassSchedule) {
		// TODO Auto-generated method stub
		ClassDAOImpl classDAOImpl = new ClassDAOImpl();
		classDAOImpl.deleteClassSchedule(updatedClassSchedule.getId());
		classDAOImpl.addClassSchedule(updatedClassSchedule);
	}

	@Transactional
	public void editFeeTemplate(FeeTemplate updatedFeeTemplate) {
		// TODO Auto-generated method stub
		ClassDAOImpl classDAOImpl = new ClassDAOImpl();
		classDAOImpl.deleteFeeTemplate(updatedFeeTemplate.getId());
		classDAOImpl.addFeeTemplate(updatedFeeTemplate);
	}

	@Transactional
	public List getAllClassWithFeeLiabitiesAndSchedule() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		String queryString = "SELECT NAME, LOCATION, START_TIME, END_TIME, DURATION, FACILITY, AMOUNT FROM CLASS as c INNER JOIN FEE_TEMPLATE as f on c.id = f.id"
				+ "INNER JOIN CLASS_SCHEDULE as cs on cs.id = c.id";
		List result = null;

		try {

			result = session.createSQLQuery(queryString).addScalar("name").addScalar("location").addScalar("startTime")
					.addScalar("endTime").addScalar("duration").addScalar("facility").addScalar("amount")
					.setResultTransformer(Transformers.aliasToBean(Result.class)).list();
			// Result r = (Result) result.get(0);
			// System.out.println(r.getName());
		} catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		}
		session.getTransaction().commit();
		return result;
	}
}
