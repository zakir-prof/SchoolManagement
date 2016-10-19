package com.accolite.school;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accolite.school.dao.StudentDAO;
import com.accolite.school.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		
		Student student = new Student();
		student.setName("Vikas");
		student.setEmail("kartik2.keshri@accoliteindia.com");
		student.setAddress("44 fisrt floor");
		student.setMobile("9902975772");
		student.setClassId(1);
		student.setTransportId(1);
		
		/*Session session = (new Configuration()).configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(student);
		tx.commit();
		session.close();*/
		
		StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
		studentDAO.save(student);
		
		studentDAO.getAllStudents();
		
	}
}
