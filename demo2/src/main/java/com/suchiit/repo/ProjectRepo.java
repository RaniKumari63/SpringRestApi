package com.suchiit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.suchiit.entity.ProjectEntity;
@Repository
public interface ProjectRepo extends JpaRepository<ProjectEntity, Long>{
	@Query(value="select pname from ProjectEntity")
	 public List<String> getAllProjectNames();
}
