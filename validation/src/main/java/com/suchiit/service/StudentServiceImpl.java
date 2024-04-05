package com.suchiit.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suchiit.exception.StudentNotFoundException;
import com.suchiit.model.Student;

import com.suchiit.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository stuRepo;
	private final String path="C:\\uploadexample\\";
	@Override
	public String saveStudent(MultipartFile file,Student student) throws Exception, IOException {
		// TODO Auto-generated method stub
		String fullpath=path+file.getOriginalFilename();
		
		student.setFilename(file.getOriginalFilename());
		student.setFiletype(file.getContentType());
		student.setFileimagePath(fullpath);
		file.transferTo(new File(fullpath));
		
		Student savedEnt = stuRepo.save(student);
		String msg=null;
		if(savedEnt!=null)
			msg="Data Inserted Success Fully";
		else
			msg="Data Not Inserted SuccessFully";
		
		return msg;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return stuRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
Optional<Student> findById = stuRepo.findById(id);
		if(findById.isPresent())
		{
			return findById.get();
		}
		else 
		throw new StudentNotFoundException("Record Not Found With Given Id "+id) ;
		
	}

	@Override
	public boolean deleteStudent(int sid) {
		// TODO Auto-generated method stub
		Student student = stuRepo.findById(sid).get();
		boolean flag=false;
		if(student!=null)
		{
			stuRepo.deleteById(sid);
			flag=true;
		}
		return flag;
	}

	@Override
	public byte[] downloadFile(int id) throws IOException {
		// TODO Auto-generated method stub
		
		Student student=stuRepo.findById(id).get();
		System.out.println("dddddddddddddddddddddddddd"+student);
		String fullpath=student.getFileimagePath();
		
		return Files.readAllBytes(new File(fullpath).toPath());
		
	}

}
