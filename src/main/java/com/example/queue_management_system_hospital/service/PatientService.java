package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    void addPatient(PatientDTO patient);
    void updatePatient(PatientDTO patient);
    boolean deletePatient(int id);
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(int id);
}
