package com.accolite.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.schoolmanagement.dao.StudentDAO;
import com.accolite.schoolmanagement.dao.StudentDAOImpl;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDAO studentDAOImpl;
	
	@RequestMapping("/xyz")
	public ModelAndView getAllStudents(){
		ModelAndView  model = new ModelAndView("students");
		model.addObject("students",studentDAOImpl.getAllStudents());
		return model;
	}
}
