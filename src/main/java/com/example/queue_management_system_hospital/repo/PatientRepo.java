package com.example.queue_management_system_hospital.repo;


import com.example.queue_management_system_hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {}
