package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.DoctorDTO;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {

    void save(DoctorDTO doctorDTO);

    DoctorDTO getById(int id);

    List<DoctorDTO> getAll();
    void update(DoctorDTO doctorDTO);
    void delete(int id);
}
