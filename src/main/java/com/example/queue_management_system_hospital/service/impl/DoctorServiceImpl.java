package com.example.queue_management_system_hospital.service.impl;


import com.example.queue_management_system_hospital.dto.DoctorDTO;

import com.example.queue_management_system_hospital.entity.Department;
import com.example.queue_management_system_hospital.entity.Doctor;

import com.example.queue_management_system_hospital.repo.DepartmentRepo;
import com.example.queue_management_system_hospital.repo.DoctorRepo;

import com.example.queue_management_system_hospital.service.DoctorService;
import com.example.queue_management_system_hospital.util.MappingUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private MappingUtil mappingUtil;

    @Autowired
    private DepartmentRepo departmentRepo; // Add this to service

    @Override
    public void addDoctor(DoctorDTO doctor) {
        Department department = departmentRepo.findById(doctor.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

        Doctor doctorEntity = mappingUtil.doctorConvertToEntity(doctor);
        doctorEntity.setDepartment(department); // Set department foreign key
        doctorRepo.save(doctorEntity);
    }


    @Override
    public void updateDoctor(DoctorDTO doctor) {
        Optional<Doctor> repoById = doctorRepo.findById(doctor.getDoctorId());
        if (repoById.isPresent()) {
            Doctor doctorEntity = mappingUtil.doctorConvertToEntity(doctor);
            doctorRepo.save(doctorEntity);
        } else {
            throw new EntityNotFoundException("Doctor not found");
        }
    }

    @Override
    public boolean deleteDoctor(int id) {
        Optional<Doctor> repoById = doctorRepo.findById(id);
        if (repoById.isPresent()) {
            doctorRepo.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Doctor not found");
        }
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepo.findAll().stream().map(mappingUtil::doctorConvertToDTO).toList();
    }

    @Override
    public DoctorDTO getDoctorById(int id) {
        Optional<Doctor> repoById = doctorRepo.findById(id);
        if (repoById.isPresent()) {
            return mappingUtil.doctorConvertToDTO(repoById.get());
        } else {
            throw new EntityNotFoundException("Doctor not found");
        }
    }
}
