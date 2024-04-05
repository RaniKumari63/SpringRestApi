package com.suchiit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.suchiit.model.Student;

public interface StudentService {
String saveStudent(MultipartFile file,Student student) throws Exception, IOException;
List<Student> getAllStudents();
Student getStudentById(int id);
byte[] downloadFile(int id) throws IOException;
boolean deleteStudent(int sid);
}
