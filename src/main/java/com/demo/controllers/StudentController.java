package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.api.Student;
import com.demo.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//Show list of all students

	@GetMapping("/show-student")
	public String showStudent(Model model) {
		
		List<Student> studentList = studentService.loadStudents();
		model.addAttribute("students", studentList);
		
		return "student-list";
	}
	
	//Add new student to the list
	
	@GetMapping("/add-new-student")
	public String addStudent(Model model ) {
		
		model.addAttribute("student",new Student());
		
		return "add-student";
	}
	
	//Save a new student or updated student info
	
	@PostMapping("/save-student")
	public String saveStudent(Student student) {	
		
		if(student.getId() == 0) {
			studentService.saveStudent(student);
		}
		else {
			studentService.update(student);
		}
		
		return "redirect:/show-student";
	}
	
	//Update student
	
	@GetMapping("/update-student")
	public String updateStudent(@RequestParam("userId") int id, Model model) {
		
		Student studentById = studentService.getStudent(id);
		
		model.addAttribute("student", studentById);
		
		return "add-student";
	
	}
	
	@GetMapping("/delete-student")
	public String deleteStudent(@RequestParam("userId")int id) {
		
		studentService.deleteStudent(id);
		
		return "redirect:/show-student";
	}
	
	
}
