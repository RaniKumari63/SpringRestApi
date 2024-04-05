package com.suchiit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suchiit.model.Student;

@RestController
public class StudentController {

@GetMapping("/student")
	public Student getStuent()
	{
		return new Student("rani","kumari");
	}
@GetMapping("/students")
public List<Student> getStudents()
{
	List<Student> students=new ArrayList<>();
	students.add(new Student("aaaa","-aaaa"));
	students.add(new Student("bbbb","-bbbb"));
	students.add(new Student("cccc","-cccc"));
	students.add(new Student("dddd","-dddd"));
	return students;
	
}
@GetMapping("/student/{firstName}/{lastName}")
public Student studentPathVariable(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName)
{
	return new Student(firstName,lastName);	
}
@GetMapping("/student1")
public Student studentQueryParam(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName)
{
	return new Student(firstName,lastName);
}
}
