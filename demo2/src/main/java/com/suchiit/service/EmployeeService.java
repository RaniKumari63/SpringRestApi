package com.suchiit.service;

import java.util.List;

import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee findEmployeeById(long id)throws RecordNotFoundException;
	public Employee updateEmployeeById(Employee employee,long id) throws RecordNotFoundException;
	public boolean deleteEmployeeById(long id) throws RecordNotFoundException;
}
