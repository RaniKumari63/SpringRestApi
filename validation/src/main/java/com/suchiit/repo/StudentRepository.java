package com.suchiit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suchiit.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
