package com.example.demo.sms.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long m_id;
	private String m_name;
	private String m_type;
	private String consumption_rule;
	private String m_days;
	
	
	
	@ManyToOne
	private Prescription prescription;
	
	public Medicine() {
		super();
	}
	public long getM_id() {
		return m_id;
	}
	public void setM_id(long m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_type() {
		return m_type;
	}
	public void setM_type(String m_type) {
		this.m_type = m_type;
	}
	public String getConsumption_rule() {
		return consumption_rule;
	}
	public void setConsumption_rule(String consumption_rule) {
		this.consumption_rule = consumption_rule;
	}
	
	public Prescription getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	
	
	
	
	
	public String getM_days() {
		return m_days;
	}
	public void setM_days(String m_days) {
		this.m_days = m_days;
	}
	public Medicine(long m_id, String m_name, String m_type, String consumption_rule, long m_days,
			Prescription prescription) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_type = m_type;
		this.consumption_rule = consumption_rule;
		
		this.prescription = prescription;
	}
	
	
	
	
	
	
	
	
	
}
