package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.dto.PatientDTO;
import com.example.queue_management_system_hospital.entity.Department;
import com.example.queue_management_system_hospital.entity.Patient;
import com.example.queue_management_system_hospital.repo.PatientRepo;
import com.example.queue_management_system_hospital.service.PatientService;
import com.example.queue_management_system_hospital.util.MappingUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private MappingUtil mappingUtil;

    @Override
    public void addPatient(PatientDTO patient) {
        Patient patientEntity = mappingUtil.patientConvertToEntity(patient);
        patientRepo.save(patientEntity);
    }

    @Override
    public void updatePatient(PatientDTO patient) {
        Optional<Patient> repoById = patientRepo.findById(patient.getPatientId());
        if (repoById.isPresent()) {
            Patient patientEntity = mappingUtil.patientConvertToEntity(patient);
            patientRepo.save(patientEntity);
        } else {
            throw new EntityNotFoundException("Patient not found");
        }
    }

    @Override
    public boolean deletePatient(int id) {
        Optional<Patient> repoById = patientRepo.findById(id);
        if (repoById.isPresent()) {
            patientRepo.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Patient not found");
        }
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepo.findAll().stream().map(mappingUtil::patientConvertToDTO).toList();
    }

    @Override
    public PatientDTO getPatientById(int id) {
        Optional<Patient> repoById = patientRepo.findById(id);
        if (repoById.isPresent()) {
            return mappingUtil.patientConvertToDTO(repoById.get());
        } else {
            throw new EntityNotFoundException("Patient not found");
        }
    }
}
