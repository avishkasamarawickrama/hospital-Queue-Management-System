package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.service.impl.DoctorServiceImpl;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/doctor")
@CrossOrigin(origins ="*")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService ;

    @PostMapping(path = "save")
    public ResponseUtil getDoctor(@RequestBody DoctorDTO doctorDTO) {
        try {
            doctorService.save(doctorDTO);
            return new ResponseUtil(201, "Doctor is saved", null);
        } catch (RuntimeException e) {
            return new ResponseUtil(400, e.getMessage(), null);
        }
    }

    @GetMapping(path = "getAll")
    public ResponseUtil getDoctors() {

        return new ResponseUtil(
                200, "doctor list retrieved", doctorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseUtil getDoctorById(@PathVariable int id) {
        try {
            return new ResponseUtil(200, "Doctor found", doctorService.getById(id));
        } catch (RuntimeException e) {
            return new ResponseUtil(404, e.getMessage(), null);
        }
    }
    @PutMapping(path = "update")
    public ResponseUtil updateDoctor(@RequestBody DoctorDTO doctorDTO) {
        try {
            doctorService.update(doctorDTO);
            return new ResponseUtil(200, "Doctor is updated", null);
        } catch (RuntimeException e) {
            return new ResponseUtil(400, e.getMessage(), null);
        }
    }


    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteDoctor(@PathVariable int id) {
        try {
            doctorService.delete(id);
            return new ResponseUtil(200, "Doctor is deleted", null);
        } catch (RuntimeException e) {
            return new ResponseUtil(404, e.getMessage(), null);
        }
    }

}
