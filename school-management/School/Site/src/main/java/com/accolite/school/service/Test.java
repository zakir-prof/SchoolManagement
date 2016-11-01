package com.accolite.school.service;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accolite.school.dao.StudentDAOImpl;

public class Test {
	public static void main(String...strings) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet-config.xml");
		
		//StudentDAOImpl studentDAOImpl = (StudentDAOImpl)context.getBean("studentDAO");
		//studentDAOImpl.getStudentById(1);
		
		System.out.println(((BasicDataSource)context.getBean("dataSource")).getUsername()
				+" "+((BasicDataSource)context.getBean("dataSource")).getPassword());
	}
}
