package com.example.demo.sms.Model;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;


@Entity
public class Student {
    
	@Id
	private String s_Id;
	private String d_Id;
	private String s_Name;
	private String s_Dept;
	private String s_Gender;
	private String b_Date;
	private String email;
	@Lob
    private Blob image;
	 
	 
	 
	    @OneToMany(mappedBy = "student")
	    private List<Prescription> prescription =new ArrayList<Prescription>();
	 
	 
	public Student() {
		super();
	}
	
	






	public Student(String s_Id, String d_Id, String s_Name, String s_Dept, String s_Gender, String b_Date, Blob image,
			List<Prescription> prescription) {
		super();
		this.s_Id = s_Id;
		this.d_Id = d_Id;
		this.s_Name = s_Name;
		this.s_Dept = s_Dept;
		this.s_Gender = s_Gender;
		this.b_Date = b_Date;
		this.image = image;
		this.prescription = prescription;
	}








	public String getS_Id() {
		return s_Id;
	}
	public void setS_Id(String s_Id) {
		this.s_Id = s_Id;
	}
	public String getS_Name() {
		return s_Name;
	}
	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}
	public String getS_Dept() {
		return s_Dept;
	}
	public void setS_Dept(String s_Dept) {
		this.s_Dept = s_Dept;
	}
	public String getS_Gender() {
		return s_Gender;
	}
	public void setS_Gender(String s_Gender) {
		this.s_Gender = s_Gender;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob blob) {
		this.image = blob;
	}

	public String getB_Date() {
		return b_Date;
	}

	public void setB_Date(String b_Date) {
		this.b_Date = b_Date;
	}

	public String getD_Id() {
		return d_Id;
	}

	public void setD_Id(String d_Id) {
		this.d_Id = d_Id;
	}

	public List<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	 
	
}
