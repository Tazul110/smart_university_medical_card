package com.example.demo.sms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.sms.Model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>
{

}
