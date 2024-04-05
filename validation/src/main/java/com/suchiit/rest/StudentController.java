package com.suchiit.rest;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.suchiit.util.ExcelGenerator;
import com.suchiit.model.Student;
import com.suchiit.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl stuService;
	
	@PostMapping("/addStudents")
	public ResponseEntity<String> createStudent( @Valid  @RequestPart("student") Student student,@RequestPart("file") MultipartFile file) throws IOException, Exception
	{

		String saveStudent = stuService.saveStudent(file, student);
	
		return ResponseEntity.ok().body(saveStudent);
	}
	
	
	/*
	 * @GetMapping("/studentsexportintoexcel") public ResponseEntity<List<Student>>
	 * exportIntoExcelFile(HttpServletResponse response) throws IOException {
	 * response.setContentType("application/octet-stream"); DateFormat dateFormatter
	 * = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss"); String currentDateTime =
	 * dateFormatter.format(new Date());
	 * 
	 * String headerKey = "Content-Disposition"; String headerValue =
	 * "attachment; filename=product" + currentDateTime + ".xlsx";
	 * response.setHeader(headerKey, headerValue);
	 * 
	 * List <Student> listOfStudents = stuService.getAllStudents(); ExcelGenerator
	 * generator = new ExcelGenerator(listOfStudents);
	 * generator.generateExcelFile(response); return
	 * ResponseEntity.ok().body(stuService.getAllStudents());
	 * 
	 * }
	 */
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents()
	{    
		return ResponseEntity.ok().body(stuService.getAllStudents());
 
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentId(@PathVariable   int id)
	{
		
		return ResponseEntity.ok().body(stuService.getStudentById(id));

	}
	@GetMapping("/downloadfilestudents/{id}")
	public ResponseEntity<byte[]> downloadfile(@PathVariable   int id) throws IOException
	{
		
		byte[] file = stuService.downloadFile(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("application/octet-stream")).body(file);
		
		

	}
	
	
	@GetMapping("/student")
	public ResponseEntity<String> deleteStudent(@RequestParam   int sid)
	{
		boolean deleteStudent = stuService.deleteStudent(sid);
		String msg=null;
		if(deleteStudent)
		{
			msg="Deleted Successfully";
		}
		else
			msg="Record is not Exist";
		
		
		
		return ResponseEntity.ok().body(msg);
	}
	
	
	
	
	
	
	
	
}
