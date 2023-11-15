package com.example.demo.sms.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sms.Model.Student;



@Service
public interface StudentService 
{
	Student create(Student student);
	
	List<Student> getAllStudents();
    
	Student viewById(String id);
	
	
   
}
