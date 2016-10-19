package com.accolite.school.dao;

import java.util.List;

import com.accolite.school.model.Student;

public interface StudentDAO {
	
	public void save(Student student);
	
	public List<Student> getAllStudents();	
}
