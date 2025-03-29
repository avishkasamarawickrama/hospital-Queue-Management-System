package com.example.queue_management_system_hospital.repo;

import com.example.queue_management_system_hospital.dto.PatientDTO;
import com.example.queue_management_system_hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {}
