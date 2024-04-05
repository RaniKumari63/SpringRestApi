package com.suchiit.service;

import java.util.List;

import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Project;

public interface ProjectService {
	public Project saveProject(Project pro);
	public List<Project> getAllProjects();
	public Project findProjectById(long id)throws RecordNotFoundException;
	public Project updateProjectById(Project project,long id) throws RecordNotFoundException;
	public boolean deleteProjectById(long id) throws RecordNotFoundException;
	public List<String> getAllProjectNames();
} 
