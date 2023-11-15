package com.example.demo.sms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sms.Model.Student;
import com.example.demo.sms.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
  
	@Autowired
	private StudentRepository studentRepository;
	
	public Student create(Student student)
	{
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
  
	 @Override
	    public Student viewById(String id) {
	        return studentRepository.findById(id).get();
	    }

	
	
	
}
