package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.service.impl.DepartmentServiceImpl;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/department")
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping( value = "save",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.addDepartment(departmentDTO);
        return new ResponseUtil(201,"Department Saved",null);
    }

    @PutMapping(value = "update",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.updateDepartment(departmentDTO);
        return new ResponseUtil(200,"Department Updated",null);
    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteDepartment(@PathVariable("id") int id) {
        departmentService.deleteDepartment(id);
        return new ResponseUtil(200,"department Deleted",null);
    }
    @GetMapping("getAll")
    public ResponseUtil getAllDepartments() {
        return new ResponseUtil(200,"Get All departments",departmentService.getAllDepartments());
    }
    @GetMapping("getDepartmentsIds")
    public ResponseUtil getDepartmentsIds() {
        return new ResponseUtil(200,"Get All departments ids",departmentService.getDepartmentsIds());
    }
    @GetMapping("getDepartmentById/{id}")
    public ResponseUtil getDepartmentById(@PathVariable int id) {
        DepartmentDTO department = departmentService.getDepartmentById(id);
        return new ResponseUtil(200, "Department found", department);
    }


}
