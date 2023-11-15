package com.example.demo.sms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.sms.Model.Emails;

public interface EmailsRepository extends JpaRepository<Emails, String>{
  
	
}
