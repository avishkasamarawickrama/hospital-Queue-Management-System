package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;


import java.util.List;

public interface DepartmentService {
    void addDepartment(DepartmentDTO departmentDTO);
    void updateDepartment(DepartmentDTO departmentDTO);
    void deleteDepartment(int id);
    List<DepartmentDTO> getAllDepartments();
    List<Integer> getDepartmentsIds();
    DepartmentDTO getDepartmentById(int id);
}
