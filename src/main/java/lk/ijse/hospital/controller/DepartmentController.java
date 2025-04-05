package lk.ijse.hospital.controller;

import lk.ijse.hospital.dto.DepartmentDTO;
import lk.ijse.hospital.service.DepartmentService;
import lk.ijse.hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*")
@RequestMapping("api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("nextId")
    public ResponseUtil getNextDepartmentId() {
        return new ResponseUtil(200, "Next Department ID", departmentService.generateNextDepartmentId());
    }
    @PostMapping("save")
    public ResponseUtil saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.saveDepartment(departmentDTO);
        return new ResponseUtil(201, "Department Saved", null);
    }

    @PutMapping("update")
    public ResponseUtil updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.updateDepartment(departmentDTO);
        return new ResponseUtil(200, "Department Updated", null);
    }

    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteDepartment(@PathVariable("id") String id) {
        departmentService.deleteDepartment(id);
        return new ResponseUtil(200, "Department Deleted", null);
    }

    @GetMapping("getAll")
    public ResponseUtil getAllDepartments() {
        return new ResponseUtil(
                200,
                "Department List",
                departmentService.getAllDepartments());
    }

    @GetMapping("getDepartmentIds")
    public ResponseUtil getDepartmentIds() {
        return new ResponseUtil(
                200,
                "Department ID List",
                departmentService.getAllDepartmentIds());
    }

    @GetMapping("getDepartmentById/{id}")
    public ResponseUtil getDepartmentById(@PathVariable String id) {
        DepartmentDTO department = departmentService.getDepartmentById(id);
        return new ResponseUtil(200, "Department Found", department);
    }
}