package com.accolite.school.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.school.dao.StudentDAO;
import com.accolite.school.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Transactional
	public long addStudent(Student p) {
		p.setClassId(1);
		p.setTransportId(1);
		long id = this.studentDAO.addStudent(p);
		return id;
	}

	@Transactional
	public void updateStudent(Student p) {
		p.setClassId(1);
		p.setTransportId(1);
		this.studentDAO.updateStudent(p);
	}

	@Transactional
	public List<Student> listStudents() {
		return this.studentDAO.listStudents();
	}

	@Transactional
	public Student getStudentById(int id) {
		return this.studentDAO.getStudentById(id);
	}

	@Transactional
	public void removeStudent(int id) {
		this.studentDAO.removeStudent(id);
	}

}