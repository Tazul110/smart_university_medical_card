package com.example.demo.sms.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Emails {
  
	@Id
	private String Email;
	private String Password;
	public Emails() {
		super();
	}
	public Emails(String email, String password) {
		super();
		Email = email;
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
