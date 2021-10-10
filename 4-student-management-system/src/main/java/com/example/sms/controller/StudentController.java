package com.example.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students",service.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//Create Student object to hold form data
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "create_student";
	}
	

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable(name = "id") Long id , Model model) {
		model.addAttribute("student",service.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student , Model model) {
		
		//Get Existing Student
		Student existingStudent = service.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//Save Updated Student
		service.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}

	
}
