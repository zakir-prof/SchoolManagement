package com.accolite.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.school.model.Student;
import com.accolite.school.service.StudentService;


@RestController
public class StudentRestController {
	
	private StudentService studentService;
	
	@Autowired(required=true)
	@Qualifier(value="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/rest/students", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listStudents(Model model) {
		System.out.println("Rest controller invoked for listing the students");
		model.addAttribute("student", new Student());
		List<Student> students = this.studentService.listStudents();
		model.addAttribute("students", students);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	//For add and update person both
	@RequestMapping(value= "/rest/student/add", method = RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student p){
		System.out.println("Rest controller invoked for adding the student");
		long id = p.getId();
		if(p.getId() == 0){
			//new person, add it
			id = this.studentService.addStudent(p);
		}else{
			//existing person, call update
			this.studentService.updateStudent(p);
		}
		
		return new ResponseEntity<Student>(p, HttpStatus.OK);
		
	}
	
	@RequestMapping("/rest/remove/{id}")
    public ResponseEntity<Student> removeStudent(@PathVariable("id") int id){
		System.out.println("Rest controller invoked for removing the student");
        this.studentService.removeStudent(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }
	
}