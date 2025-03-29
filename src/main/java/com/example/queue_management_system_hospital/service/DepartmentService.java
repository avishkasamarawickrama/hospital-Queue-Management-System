package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    void addDepartment(DepartmentDTO department);
    void updateDepartment(DepartmentDTO department);
    boolean deleteDepartment(int id);
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO getDepartmentById(int id);
}
