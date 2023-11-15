package com.example.demo.sms.Model;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name ="prescription")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long p_Id;
	private String Medication;
	private String Dosage;
	private String Instructions;
	private Long refill;
	private Date date = new Date();
	
	@ManyToOne
	private Student student;
	
	@OneToMany(mappedBy = "prescription")
    private List<Medicine> medicines;
	
	public Prescription() {
		super();
	}




	public long getP_Id() {
		return p_Id;
	}

	public void setP_Id(long p_Id) {
		this.p_Id = p_Id;
	}

	public String getMedication() {
		return Medication;
	}

	public void setMedication(String medication) {
		this.Medication = medication;
	}

	public String getDosage() {
		return Dosage;
	}

	public void setDosage(String dosage) {
		Dosage = dosage;
	}

	public String getInstructions() {
		return Instructions;
	}

	public void setInstructions(String instructions) {
		Instructions = instructions;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getRefill() {
		return refill;
	}

	public void setRefill(Long refill) {
		this.refill = refill;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	
	
	
}
