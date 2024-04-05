package com.suchiit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suchiit.entity.StudentEntity;
import com.suchiit.exception.ResourceNotFoundException;
import com.suchiit.model.Student;
import com.suchiit.repo.StudentRepo;
import com.suchiit.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
@Autowired
private  StudentRepo studentrepo;

	
	@Override
	public StudentEntity saveStudent(Student stu) {
		// TODO Auto-generated method stub
		StudentEntity stuEntity=new StudentEntity();
		BeanUtils.copyProperties(stu, stuEntity);
		StudentEntity stuEntitysave=studentrepo.save(stuEntity);
		return stuEntitysave;
	}


	@Override
	public List<Student> getAllStudents() {
		List<StudentEntity> allstudents=studentrepo.findAll();
		
		List<Student> students=new ArrayList<Student>();
		allstudents.forEach(stu->{
			
			
			Student student1=new Student();
			BeanUtils.copyProperties(stu, student1);
			students.add(student1);
		});
		
		System.out.println(students);
		return students;
	}


	@Override
	public Student getStudentById(long stuId) {
		
		/*
		 * StudentEntity stuEn=studentrepo.findById(stuId).orElseThrow(()->new
		 * IllegalArgumentException("Invalid Student id:"+stuId)); Student stu=new
		 * Student(); BeanUtils.copyProperties(stuEn, stu); return stu;
		 */
		Optional<StudentEntity> stuEn=studentrepo.findById(stuId);
	 Student stu=new Student();
		if(stuEn.isPresent())
				{
					BeanUtils.copyProperties(stuEn.get(), stu);
				return stu;
				}
		else
		{
			throw new ResourceNotFoundException("Student", "id", stuId);
		}
	
	}


	@Override
	public void deleteStudentByNo(long stuId) {
		// TODO Auto-generated method stub
	studentrepo.deleteById(stuId);	
	}


	@Override
	public Student updateStudent(Student stu,long stuId) {
		// TODO Auto-generated method stub

		StudentEntity stuEn = studentrepo.findById(stuId).orElseThrow(() -> new IllegalArgumentException("Invalid Student id:" + stuId));
		if(stuEn.getSid()!=0)
		BeanUtils.copyProperties(stu, stuEn);
		else
			throw new ResourceNotFoundException("Student", "id", stuId);
		StudentEntity stuEnsave=studentrepo.save(stuEn);
		Student stusave=new Student();
		BeanUtils.copyProperties(stuEnsave, stusave);
		
		return stusave;		 
	}

}
