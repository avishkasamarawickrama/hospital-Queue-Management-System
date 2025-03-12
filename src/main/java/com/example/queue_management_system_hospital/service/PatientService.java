package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    void save(PatientDTO patientDTO);

    PatientDTO getById(int id);

    List<PatientDTO> getAll();
    void update(PatientDTO patientDTO);
    void delete (int id);
}
