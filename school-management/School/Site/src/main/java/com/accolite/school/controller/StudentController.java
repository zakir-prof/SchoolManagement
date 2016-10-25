package com.accolite.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accolite.school.model.Student;
import com.accolite.school.service.StudentService;


@Controller
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired(required=true)
	@Qualifier(value="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "students", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("students", this.studentService.listStudents());
		return "students";
	}
	
	//For add and update person both
	@RequestMapping(value= "/student/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student p){
		
		if(p.getId() == 0){
			//new person, add it
			this.studentService.addStudent(p);
		}else{
			//existing person, call update
			this.studentService.updateStudent(p);
		}
		
		return "redirect:/students";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id){
		
        this.studentService.removeStudent(id);
        return "redirect:/students";
    }
 
    @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentService.getStudentById(id));
        model.addAttribute("students", this.studentService.listStudents());
        return "students";
    }
	
}