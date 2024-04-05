package com.suchiit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suchiit.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long>{

}
