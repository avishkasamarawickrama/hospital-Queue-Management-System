package lk.ijse.hospital.service.impl;

import lk.ijse.hospital.dto.DepartmentDTO;
import lk.ijse.hospital.entity.Department;
import lk.ijse.hospital.repo.DepartmentRepo;
import lk.ijse.hospital.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveDepartment(DepartmentDTO departmentDTO) {
        if (departmentRepo.existsById(departmentDTO.getDepartmentId())) {
            throw new RuntimeException("Department already exists");
        }
        departmentRepo.save(modelMapper.map(departmentDTO, Department.class));
    }

    @Override
    public void updateDepartment(DepartmentDTO departmentDTO) {
        if (!departmentRepo.existsById(departmentDTO.getDepartmentId())) {
            throw new RuntimeException("Department does not exist");
        }
        departmentRepo.save(modelMapper.map(departmentDTO, Department.class));
    }

    @Override
    public void deleteDepartment(String id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return modelMapper.map(departmentRepo.findAll(),
                new TypeToken<List<DepartmentDTO>>() {}.getType());
    }

    @Override
    public List<String> getAllDepartmentIds() {
        return departmentRepo.getAllDepartmentIds();
    }

    @Override
    public DepartmentDTO getDepartmentById(String id) {
        Department department = departmentRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Department does not exist")
        );
        return modelMapper.map(department, DepartmentDTO.class);
    }
    @Override
    public String generateNextDepartmentId() {
        String lastId = departmentRepo.getLastDepartmentId();
        if (lastId == null) {
            return "DEPT001"; // Initial ID if no departments exist
        }

        // Extract the numeric part and increment
        String numericPart = lastId.replaceAll("\\D+", "");
        int nextNum = Integer.parseInt(numericPart) + 1;

        // Format with leading zeros
        return String.format("DEPT%03d", nextNum);
    }
}