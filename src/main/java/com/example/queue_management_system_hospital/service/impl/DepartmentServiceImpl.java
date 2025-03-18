package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.entity.Department;
import com.example.queue_management_system_hospital.repo.DepartmentRepo;
import com.example.queue_management_system_hospital.service.DepartmentService;
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

    @Override
    public void addDepartment(DepartmentDTO departmentDTO) {
        if (departmentRepo.existsById(departmentDTO.getDepartment_id())){
            throw new RuntimeException("department already exists");
        }
        departmentRepo.save(modelMapper.map(departmentDTO, Department.class));

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


