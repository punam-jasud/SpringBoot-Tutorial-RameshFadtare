package com.example.sms.service;

import java.util.List;

import com.example.sms.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();

	public Student saveStudent(Student student);

	public Student getStudentById(Long id);
	
	public Student updateStudent(Student student);

	public void deleteStudentById(Long id);
}
