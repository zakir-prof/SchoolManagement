package com.accolite.schoolmanagement.dao;

import java.util.List;

import com.accolite.schoolmanagement.model.Student;

public interface StudentDAO {
	
	public void save(Student student);
	
	public List<Student> getAllStudents();	
}
