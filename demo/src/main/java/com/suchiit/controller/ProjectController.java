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
import com.suchiit.model.Project;
import com.suchiit.service.ProjectService;


@RestController
@RequestMapping("/restapi/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectserviceimpl;

	@PostMapping("/addPro")
	public ResponseEntity<String> saveProject(@RequestBody Project project) {
		String msg = "";
	
		Project saveproject = projectserviceimpl.saveProject(project);
		if (saveproject != null) {
			msg = "Data Inserted Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);

		} else {
			msg = "Data not  Inserted Successfully";
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}

	@GetMapping("/fetchPro")
	public List<Project> getAllProjects() {
		return projectserviceimpl.getAllProjects();

	}

	@PutMapping("/update/{pid}")
	public ResponseEntity<String> updateProject(@RequestBody Project project, @PathVariable("pid") long pid)
			throws RecordNotFoundException {
		String msg = "";
		Project updateproject = projectserviceimpl.updateProjectById(project, pid);
		if (updateproject != null) {
			msg = "Data Updated Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);

		} else {
			msg = "Data not  Updated Successfully";
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

	}

	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<String> deleteProject(@PathVariable("pid") long pid) throws RecordNotFoundException {
		String msg = "";
		boolean flag = false;
		flag = projectserviceimpl.deleteProjectById(pid);		
		if (flag) {
			msg = "Data deleted Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			msg = "Data not  deleted Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

	}
@GetMapping("/proNames")
	public List<String> getAllProjectNames() {
		List<String> allProjectNames=projectserviceimpl.getAllProjectNames(); 
		return allProjectNames;
}
}
