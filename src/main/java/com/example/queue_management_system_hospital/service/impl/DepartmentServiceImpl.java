package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
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

    public void save(DepartmentDTO departmentDTO){
        if (departmentRepo.existsById(departmentDTO.getDepartment_id()));
        departmentRepo.save(modelMapper.map(departmentDTO, Department.class));
        throw new RuntimeException("department already exists");

    }
    @Override
    public DepartmentDTO getById(int id){
        Optional<Department> optionalDepartment = departmentRepo.findById(id);
        if (optionalDepartment.isPresent()){
            return modelMapper.map(optionalDepartment.get(),DepartmentDTO.class);

        }
        throw new RuntimeException("department not found ");
    }
    public List<DepartmentDTO> getAll(){
        return modelMapper.map(
                departmentRepo.findAll(),
                new TypeToken<List<DepartmentDTO>>(){}.getType()
        );
    }
    public void update(DepartmentDTO departmentDTO){
        if (departmentRepo.existsById(departmentDTO.getDepartment_id())){
            departmentRepo.save(
                    modelMapper.map(departmentDTO,Department.class)
            );
        }
        throw new RuntimeException("department doesn't exists");
    }
    public void delete(int id){
        if (departmentRepo.existsById(id)){
            departmentRepo.deleteById(id);
        }
        throw new RuntimeException("department doesn't exists");
    }

}
