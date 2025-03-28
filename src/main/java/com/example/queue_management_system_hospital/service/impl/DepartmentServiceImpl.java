package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.entity.Department;
import com.example.queue_management_system_hospital.repo.DepartmentRepo;
import com.example.queue_management_system_hospital.service.DepartmentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager; // Inject EntityManager

    @Override
    public void addDepartment(DepartmentDTO departmentDTO) {
        if (departmentRepo.existsById(departmentDTO.getDepartment_id())){
            throw new RuntimeException("department already exists");
        }
        departmentRepo.save(modelMapper.map(departmentDTO, Department.class));

    }
    @Transactional
    public Department updateDepartment(int id, Department department) {
        Department existingDepartment = departmentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

        // Update fields
        existingDepartment.setDepartment_name(department.getDepartment_name());

        return entityManager.merge(existingDepartment); // Use merge correctly
    }

    @Override
    public void updateDepartment(DepartmentDTO departmentDTO) {
        if (!departmentRepo.existsById(departmentDTO.getDepartment_id())) {
            throw new RuntimeException("department does not exist");
        }
        departmentRepo.save(modelMapper.map(departmentDTO, Department.class));
    }

    @Override
    public void deleteDepartment(int id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return modelMapper.map(departmentRepo.findAll(),
                new TypeToken<List<DepartmentDTO>>(){}.getType());
    }

    @Override
    public List<Integer> getDepartmentsIds() {
        return departmentRepo.findAllDepartmentsIds();
    }

    @Override
    public DepartmentDTO getDepartmentById(int id) {
        return departmentRepo.findDepartmentsByIds(id);
    }
}


