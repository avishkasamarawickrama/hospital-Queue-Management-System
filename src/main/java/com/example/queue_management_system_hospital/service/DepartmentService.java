package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.dto.DoctorDTO;

import java.util.List;

public interface DepartmentService {
    void save(DepartmentDTO departmentDTO);

    DepartmentDTO getById(int id);

    List<DepartmentDTO> getAll();
    void update(DepartmentDTO departmentDTO);
    void delete(int id);
}
