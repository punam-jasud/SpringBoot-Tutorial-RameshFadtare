package com.springboot.crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.model.Employee;
import com.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}

	//Build create employee Rest Api
	//http://localhost:8080/api/employees
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(service.saveEmployee(emp), HttpStatus.CREATED);
	}
	
	//Build get all employees Rest Api
	//http://localhost:8080/api/employees
	@GetMapping
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	//Build get employee by Id Rest Api
	//http://localhost:8080/api/employees/1
	@GetMapping("/{id}")
	public ResponseEntity<Employee>  getEmployeeById(@PathVariable("id") long empId) {
		return  new ResponseEntity<Employee>(service.getEmployee(empId),HttpStatus.OK);
	}
	
	//Build update employee Rest Api
	//http://localhost:8080/api/employees/1
	@PutMapping("/{id}")
	public ResponseEntity<Employee>  updateEmployee(@RequestBody Employee emp,@PathVariable("id") long empId) {
		return  new ResponseEntity<Employee>(service.updateEmployee(emp,empId),HttpStatus.OK);
	}
	
	//Build delete employee Rest Api
	//http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String>  deleteEmployee(@PathVariable("id") long empId) {
		service.deleteEmployee(empId);
		return  new ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK);
	}
	 
}
