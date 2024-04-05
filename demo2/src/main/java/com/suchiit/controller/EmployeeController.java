package com.suchiit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Employee;
import com.suchiit.service.EmployeeService;


@RestController
@RequestMapping("/restapi/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeserviceimpl;

	@PostMapping("/addEmp")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		String msg = "";
		Employee saveemployee = employeeserviceimpl.saveEmployee(employee);
		if (saveemployee != null) {
			msg = "Data Inserted Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);

		} else {
			msg = "Data not  Inserted Successfully";
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}

	@GetMapping("/fetchEmp")
	public List<Employee> getAllEmployees() {
		return employeeserviceimpl.getAllEmployees();

	}

	@PutMapping("/update/{eid}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee, @PathVariable("eid") long eid)
			throws RecordNotFoundException {
		String msg = "";
		Employee updateemployee = employeeserviceimpl.updateEmployeeById(employee, eid);
		if (updateemployee != null) {
			msg = "Data Updated Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);

		} else {
			msg = "Data not  Updated Successfully";
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}

	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("eid") long eid) throws RecordNotFoundException {
		String msg = "";
		boolean flag = false;
		flag = employeeserviceimpl.deleteEmployeeById(eid);		
		if (flag) {
			msg = "Data deleted Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			msg = "Data not  deleted Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

	}

}