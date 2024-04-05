package com.suchiit.service;

import java.util.List;

import com.suchiit.entity.StudentEntity;
import com.suchiit.model.Student;

public interface StudentService {
StudentEntity saveStudent(Student stu);
List<Student> getAllStudents();
public Student getStudentById(long stuId);
public void deleteStudentByNo(long stuId);
public Student updateStudent(Student stu,long id);


}
