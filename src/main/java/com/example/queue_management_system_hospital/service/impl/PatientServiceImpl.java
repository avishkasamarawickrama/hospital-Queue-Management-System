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
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addPatient(PatientDTO patientDTO) {
        if (patientRepo.existsById(patientDTO.getPatient_id())) {
            throw new RuntimeException("Patient already exists");
        }
        patientRepo.save(modelMapper.map(patientDTO, Patient.class));
    }


    @Override
    public void updatePatient(PatientDTO patientDTO) {
        if (!patientRepo.existsById(patientDTO.getPatient_id())) {
            throw new RuntimeException("Patient does not exist");
        }
        patientRepo.save(modelMapper.map(patientDTO, Patient.class));
    }



    @Override
    public void deletePatient(int id) {
        patientRepo.deleteById(id);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return modelMapper.map(patientRepo.findAll(),
                new TypeToken<List<PatientDTO>>() {}.getType());
    }

    @Override
    public List<Integer> getPatientsId() {
        return patientRepo.getPatientsId();
    }

   /* @Override
    public CustomerDTO getCustomerById(String id) {
        return customerRepo.findNameById(id);
    }*/

    @Override
    public PatientDTO getPatientById(int id) {
        Patient patient = patientRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Patient does not exist")
        );
        return modelMapper.map(patient, PatientDTO.class);
    }

}
