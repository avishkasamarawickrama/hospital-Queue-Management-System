package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.dto.DoctorDTO;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public interface DoctorService {

    void addDoctor(DoctorDTO doctor);
    void updateDoctor(DoctorDTO doctor);
    boolean deleteDoctor(int id);
    List<DoctorDTO> getAllDoctors();
    DoctorDTO getDoctorById(int id);
}
