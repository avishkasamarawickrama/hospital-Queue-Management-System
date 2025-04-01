package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.service.DepartmentService;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/department")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDepartment(@RequestBody DepartmentDTO department) {
        if (department != null) {
            try {
                departmentService.addDepartment(department);
                return new ResponseUtil(200,"Department Saved",null);
            } catch (Exception e) {
                return new ResponseUtil(500,"Department not saved",null);
            }
        } else {
            return new ResponseUtil(500,"Department not saved",null);
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDepartment(@RequestBody DepartmentDTO department) {
        if (department != null) {
            try {
                departmentService.updateDepartment(department);
                return new ResponseUtil(200,"Department Updated",null);
            } catch (Exception e) {
                return new ResponseUtil(500,"Department not updated",null);
            }
        } else {
            return new ResponseUtil(500,"Department not updated",null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseUtil deleteDepartment(@PathVariable("id") int id) {
        try {
            departmentService.deleteDepartment(id);
            return new ResponseUtil(200,"Department Deleted",null);
        } catch (Exception e) {
            return new ResponseUtil(500,"Department not deleted",null);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDepartments() {
        return new ResponseUtil(200,"Get All departments",departmentService.getAllDepartments());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDepartmentById(@PathVariable int id) {
        try {
            return new ResponseUtil(200,"Get Department by Id",departmentService.getDepartmentById(id));
        } catch (Exception e) {
            return new ResponseUtil(500,"Department not found",null);
        }
    }
}
