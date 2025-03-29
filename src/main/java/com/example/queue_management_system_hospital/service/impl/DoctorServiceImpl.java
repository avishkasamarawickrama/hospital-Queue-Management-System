package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.entity.Doctor;

import com.example.queue_management_system_hospital.repo.DoctorRepo;
import com.example.queue_management_system_hospital.repo.UserRepo;
import com.example.queue_management_system_hospital.service.DoctorService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Override
    public void addDoctor(DoctorDTO doctorDTO) {

    }

    @Override
    public void updateDoctor(DoctorDTO doctorDTO) {

    }

    @Override
    public void deleteDoctor(int id) {

    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return List.of();
    }

    @Override
    public List<Integer> getDoctorsId() {
        return List.of();
    }

    @Override
    public DoctorDTO getDoctorById(int id) {
        return null;
    }
}
