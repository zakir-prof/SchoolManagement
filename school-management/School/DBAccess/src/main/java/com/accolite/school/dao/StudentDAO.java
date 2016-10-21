package com.accolite.school.dao;

import java.util.List;

import com.accolite.school.model.Student;

public interface StudentDAO {
	
	public long addStudent(Student student);
	
	public void updateStudent(Student student);
	
	public List<Student> listStudents();

	public Student getStudentById(int id);

	public void removeStudent(int id);	
	
}
