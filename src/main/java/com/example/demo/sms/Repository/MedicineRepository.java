package com.example.demo.sms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.sms.Model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>
{

}
