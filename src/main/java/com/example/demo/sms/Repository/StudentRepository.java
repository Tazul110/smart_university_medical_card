package com.example.demo.sms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.sms.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,String>
{

}
