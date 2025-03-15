package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.service.impl.DepartmentServiceImpl;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/department")
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping(path = "save")
    public ResponseUtil getDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.save(departmentDTO);

        return new ResponseUtil(201, "department is saved", null);

    }

    @GetMapping(path = "getAll")
    public ResponseUtil getDepartments() {

        return new ResponseUtil(
                200, "department list", departmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseUtil getDepartmentById(@PathVariable int id) {
        return new ResponseUtil(200, "Success", departmentService.getById(id));
    }
    @PutMapping(path = "update")
    public ResponseUtil updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.update(departmentDTO);

        return new ResponseUtil(200, "Department is updated", null);

    }


    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteDepartment(@PathVariable int id) {
        departmentService.delete(id);
        return new ResponseUtil(200,"Department is deleted",null);
    }
}
