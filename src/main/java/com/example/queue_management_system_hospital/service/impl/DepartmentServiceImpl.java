package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.entity.Department;
import com.example.queue_management_system_hospital.repo.DepartmentRepo;
import com.example.queue_management_system_hospital.service.DepartmentService;
import com.example.queue_management_system_hospital.util.MappingUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private MappingUtil mappingUtil;

    @Override
    public void addDepartment(DepartmentDTO department) {
        Department departmentEntity = mappingUtil.departmentConvertToEntity(department);
        departmentRepo.save(departmentEntity);
    }

    @Override
    public void updateDepartment(DepartmentDTO department) {
        Optional<Department> repoById = departmentRepo.findById(department.getDepartmentId());
        if (repoById.isPresent()) {
            Department departmentEntity = mappingUtil.departmentConvertToEntity(department);
            departmentRepo.save(departmentEntity);
        } else {
            throw new EntityNotFoundException("Department not found");
        }
    }

    @Override
    public boolean deleteDepartment(int id) {
        Optional<Department> repoById = departmentRepo.findById(id);
        if (repoById.isPresent()) {
            departmentRepo.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Department not found");
        }
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepo.findAll().stream().map(mappingUtil::departmentConvertToDTO).toList();
    }

    @Override
    public DepartmentDTO getDepartmentById(int id) {
        Optional<Department> repoById = departmentRepo.findById(id);
        if (repoById.isPresent()) {
            return mappingUtil.departmentConvertToDTO(repoById.get());
        } else {
            throw new EntityNotFoundException("Department not found");
        }
    }
}


