package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.entity.Department;
import com.example.queue_management_system_hospital.repo.DepartmentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface DepartmentService {

    Department updateDepartment(int id, Department department);

    void addDepartment(DepartmentDTO departmentDTO);
    void updateDepartment(DepartmentDTO departmentDTO);
    void deleteDepartment(int id);
    List<DepartmentDTO> getAllDepartments();
    List<Integer> getDepartmentsIds();
    DepartmentDTO getDepartmentById(int id);
}
