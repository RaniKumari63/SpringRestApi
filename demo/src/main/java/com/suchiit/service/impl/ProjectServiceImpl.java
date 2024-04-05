package com.suchiit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.suchiit.entity.ProjectEntity;
import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Project;
import com.suchiit.repo.ProjectRepo;
import com.suchiit.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepo projectrepo;

	public Project saveProject(Project pro1) {
		
		ProjectEntity proEn = new ProjectEntity();
		BeanUtils.copyProperties(pro1, proEn);
		ProjectEntity proEnSave = projectrepo.save(proEn);
		Project project = new Project();
		BeanUtils.copyProperties(proEnSave, project);
		return project;

	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub

		List<ProjectEntity> allProjectsEntity = projectrepo.findAll();
		List<Project> allProjects = new ArrayList<Project>();
		allProjectsEntity.forEach(p -> {

			Project project = new Project();
			BeanUtils.copyProperties(p, project);
			allProjects.add(project);

		});
		return allProjects;
	}

	@Override
	public Project findProjectById(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<ProjectEntity> findById= projectrepo.findById(id);
		ProjectEntity projectentity=new ProjectEntity();
		if(findById.isPresent())
		{ 
			projectentity=findById.get();
		Project project = new Project();
		BeanUtils.copyProperties(projectentity, project);
		return project;
		
		}
		else
		{
			throw new RecordNotFoundException("Record Not Found with given id"+id);
		}
		

	}

	@Override
	public Project updateProjectById(Project project, long id) throws RecordNotFoundException {
		ProjectEntity projectentity = projectrepo.findById(id).get();
		if (projectentity.getPid() != 0) {
			project.setPid(projectentity.getPid());
			BeanUtils.copyProperties(project, projectentity);

		} else {
			throw new RecordNotFoundException("Given Record is Not Exists");
		}
		ProjectEntity saveEntity = projectrepo.save(projectentity);
		Project pro = new Project();
		BeanUtils.copyProperties(saveEntity, pro);
		return pro;
	}

	@Override
	public boolean deleteProjectById(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean flag = false;
		ProjectEntity projectentity = projectrepo.findById(id).get();
		if (projectentity.getPid() != 0) {
			projectrepo.deleteById(id);
			flag = true;

		} else {
			throw new RecordNotFoundException("Given Record is Not Exists");
		}

		return flag;

	}

	@Override
	public List<String> getAllProjectNames() {
		List<String> allProjectNames=projectrepo.getAllProjectNames(); 
		return allProjectNames;
	}
}
