package com.example.queue_management_system_hospital.util;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.entity.Department;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MappingUtil {
    @Autowired
    private ModelMapper modelMapper;

    public DepartmentDTO departmentConvertToDTO(Department department) {
        return modelMapper.map(department, DepartmentDTO.class);
    }

    public Department departmentConvertToEntity(DepartmentDTO departmentDTO) {
        return modelMapper.map(departmentDTO, Department.class);
    }

    public List<DepartmentDTO> departmentListConvertToDTOList(List<Department> departments) {
        return departments.stream().map(this::departmentConvertToDTO).toList();
    }
}
