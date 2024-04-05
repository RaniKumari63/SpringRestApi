package com.suchiit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suchiit.entity.StudentEntity;
import com.suchiit.model.Student;
import com.suchiit.service.StudentService;

@RestController
@RequestMapping("/students/")
public class StudentController {
	@Autowired
	private StudentService studentservice;

	@PostMapping("save")
	public ResponseEntity<StudentEntity> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<StudentEntity>(studentservice.saveStudent(student), HttpStatus.CREATED);

	}

	@GetMapping("get")
	public List<Student> getAllStudents() {

		return studentservice.getAllStudents();

	}

	@GetMapping("get/{stuid}")
	public Student getStudentById(@PathVariable("stuid") long stuid) {
		return studentservice.getStudentById(stuid);

	}

	@PutMapping("delete/{stuid}")
	public void deleteStudentById(@PathVariable("stuid") long stuid) {
		studentservice.deleteStudentByNo(stuid);
	}

	@PutMapping("update/{stuid}")
	public  ResponseEntity<Student> updateStudentById(@RequestBody Student stu,@PathVariable("stuid") long stuid) {
		
		return new ResponseEntity<Student>(studentservice.updateStudent(stu,stuid), HttpStatus.OK);
		
	}

}
