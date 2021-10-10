package com.springboot.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.exception.ResourceNotFoundException;
import com.springboot.crud.model.Employee;
import com.springboot.crud.repository.EmployeeRepository;
import com.springboot.crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployee(long id) {
//	 Optional<Employee> employee	= repo.findById(id);
//	 if(employee.isPresent()) {
//		 return employee.get();
//				 
//	 }
//	 else {
//		 throw new ResourceNotFoundException("Employee", "Id", id);
//	 }	
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee emp, long id) {
		Employee existingEmployee = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(emp.getFirstName());
		existingEmployee.setLastName(emp.getLastName());
		existingEmployee.setEmail(emp.getEmail());
		
		repo.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		repo.deleteById(id);
		
	}

}
