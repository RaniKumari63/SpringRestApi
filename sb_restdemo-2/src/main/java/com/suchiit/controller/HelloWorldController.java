package com.suchiit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {
//get
	//post
	//put
	//delete
	//http://localhost:8080/hello-world
	@GetMapping("/hello-world")
	public String helloworld()
	{
		return "HelloWorld!";
		
	}
	
	
}
