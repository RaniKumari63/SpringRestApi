package com.suchiit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suchiit.model.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
