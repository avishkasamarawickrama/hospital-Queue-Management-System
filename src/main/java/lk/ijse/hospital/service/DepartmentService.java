package lk.ijse.hospital.service;

import lk.ijse.hospital.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    void saveDepartment(DepartmentDTO departmentDTO);
    void updateDepartment(DepartmentDTO departmentDTO);
    void deleteDepartment(String id);
    List<DepartmentDTO> getAllDepartments();
    List<String> getAllDepartmentIds();
    DepartmentDTO getDepartmentById(String id);

    String generateNextDepartmentId();
}