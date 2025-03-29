package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.PatientDTO;
import com.example.queue_management_system_hospital.entity.Patient;
import com.example.queue_management_system_hospital.repo.PatientRepo;
import com.example.queue_management_system_hospital.service.PatientService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {


    @Override
    public void addPatient(PatientDTO patientDTO) {

    }

    @Override
    public void updatePatient(PatientDTO patientDTO) {

    }

    @Override
    public void deletePatient(int id) {

    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return List.of();
    }

    @Override
    public List<Integer> getPatientsId() {
        return List.of();
    }

    @Override
    public PatientDTO getPatientById(int id) {
        return null;
    }
}
