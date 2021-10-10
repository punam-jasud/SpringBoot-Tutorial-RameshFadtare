package com.springboot.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	//http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Punam","Jasud");
	}
	
	//http://localhost:8080/students
		@GetMapping("/students")
		public List<Student> getStudents() {
			List<Student> list = new ArrayList<>();
			list.add(new Student("Punam","Jasud"));
			list.add(new Student("Krishna","Jadhav"));
			list.add(new Student("Vidya","Jasud"));
			list.add(new Student("Yogesh","Khedkar"));
			return list;
		}
	
}
