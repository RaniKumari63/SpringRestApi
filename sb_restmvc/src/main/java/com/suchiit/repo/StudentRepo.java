package com.suchiit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suchiit.entity.StudentEntity;
@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

}
