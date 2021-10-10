package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getEmployee(long id);
	public Employee updateEmployee(Employee emp, long id);
	public void deleteEmployee(long id);
}
