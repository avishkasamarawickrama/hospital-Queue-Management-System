package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.DoctorDTO;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {

    void addDoctor(DoctorDTO doctorDTO);
    void updateDoctor(DoctorDTO doctorDTO);
    void deleteDoctor(int id);
    List<DoctorDTO> getAllDoctors();
    List<Integer> getDoctorsId();

    DoctorDTO getDoctorById(int id);
}
