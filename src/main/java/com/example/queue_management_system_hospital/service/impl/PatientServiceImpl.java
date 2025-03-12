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

    public void save(PatientDTO patientDTO){
        if (patientRepo.existsById(patientDTO.getPatient_id()));
        patientRepo.save(modelMapper.map(patientDTO, Patient.class));
        throw new RuntimeException("patient already exists");

    }
    @Override
    public PatientDTO getById(int id){
        Optional<Patient>optionalPatient = patientRepo.findById(id);
        if (optionalPatient.isPresent()){
            return modelMapper.map(optionalPatient.get(),PatientDTO.class);

        }
        throw new RuntimeException("patient not found ");
    }
    public List<PatientDTO>getAll(){
        return modelMapper.map(
                patientRepo.findAll(),
                new TypeToken<List<PatientDTO>>(){}.getType()
        );
    }
    public void update(PatientDTO patientDTO){
        if (patientRepo.existsById(patientDTO.getPatient_id())){
            patientRepo.save(
                    modelMapper.map(patientDTO,Patient.class)
            );
        }
        throw new RuntimeException("patient doesn't exists");
    }
    public void delete(int id){
        if (patientRepo.existsById(id)){
            patientRepo.deleteById(id);
        }
        throw new RuntimeException("patient doesn't exists");
    }
}
