package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    void addPatient(PatientDTO patientDTO);
    void updatePatient(PatientDTO patientDTO);
    void deletePatient(int id);
    List<PatientDTO> getAllPatients();
    List<Integer> getPatientsId();

    PatientDTO getPatientById(int id);
}
