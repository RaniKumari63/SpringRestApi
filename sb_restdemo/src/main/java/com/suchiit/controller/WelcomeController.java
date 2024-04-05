package com.suchiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suchiit.model.Student;

@RestController
public class WelcomeController {
	@GetMapping("/welcome")
public String sayHello()
{
	return "Welcome Boss";
}
	@GetMapping("/hi/{name}")
	public String sayHi(@PathVariable("name") String name)
	{
		return "Hello:"+name;
		
	}
	@GetMapping("/bye")
	public String sayGnt(@RequestParam("name") String name)
	{
		return "Hello:"+name;
		
	}
	@GetMapping("/stu")
	public Student handleStudent()
	{
		Student stu=new Student();
		stu.setSno(100);
		stu.setSname("rani");
		stu.setSadd("hyd");
		return stu;
	}
}
