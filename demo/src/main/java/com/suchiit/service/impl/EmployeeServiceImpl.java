package com.suchiit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suchiit.entity.EmployeeEntity;

import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Employee;

import com.suchiit.repo.EmployeeRepo;
import com.suchiit.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired
private EmployeeRepo employeerepo;
	@Override
	public Employee saveEmployee(Employee emp) {
		EmployeeEntity empEn = new EmployeeEntity();
		BeanUtils.copyProperties(emp, empEn);
		EmployeeEntity empEnSave = employeerepo.save(empEn);
		Employee employee = new Employee();
		BeanUtils.copyProperties(empEnSave, employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> allEmployeesEntity = employeerepo.findAll();
		List<Employee> allEmployees = new ArrayList<Employee>();
		allEmployeesEntity.forEach(e -> {

			Employee employee = new Employee();
			BeanUtils.copyProperties(e, employee);
			allEmployees.add(employee);

		});
		return allEmployees;
	}

	@Override
	public Employee findEmployeeById(long id) throws RecordNotFoundException {
		EmployeeEntity employeeentity = employeerepo.findById(id).get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeentity, employee);
		return employee;
	}

	@Override
	public Employee updateEmployeeById(Employee employee, long id) throws RecordNotFoundException {
		EmployeeEntity employeeentity = employeerepo.findById(id).get();
		if (employeeentity.getEid() != 0) {
			BeanUtils.copyProperties(employee, employeeentity);

		} else {
			throw new RecordNotFoundException("Given Record is Not Exists");
		}
		EmployeeEntity saveEntity = employeerepo.save(employeeentity);
		Employee emp = new Employee();
		BeanUtils.copyProperties(saveEntity, emp);
		return emp;
	}

	@Override
	public boolean deleteEmployeeById(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
				boolean flag = false;
				EmployeeEntity employeeentity = employeerepo.findById(id).get();
				if (employeeentity.getEid() != 0) {
					employeerepo.deleteById(id);
					flag = true;

				} else {
					throw new RecordNotFoundException("Given Record is Not Exists");
				}

				return flag;

	}

	
}
