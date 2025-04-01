package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.DepartmentDTO;
import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.service.DoctorService;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/doctor")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DoctorController {

    @Autowired
    private DoctorService doctorService ;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDoctor(@RequestBody DoctorDTO doctor) {
        if (doctor != null) {
            try {
                doctorService.addDoctor(doctor);
                return new ResponseUtil(200,"Doctor Saved",null);
            } catch (Exception e) {
                return new ResponseUtil(500,"Doctor not saved",null);
            }
        } else {
            return new ResponseUtil(500,"Doctor not saved",null);
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDoctor(@RequestBody DoctorDTO doctor) {
        if (doctor != null) {
            try {
                doctorService.updateDoctor(doctor);
                return new ResponseUtil(200,"Doctor Updated",null);
            } catch (Exception e) {
                return new ResponseUtil(500,"Doctor not updated",null);
            }
        } else {
            return new ResponseUtil(500,"Doctor not updated",null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseUtil deleteDoctor(@PathVariable("id") int id) {
        try {
            doctorService.deleteDoctor(id);
            return new ResponseUtil(200,"Doctor Deleted",null);
        } catch (Exception e) {
            return new ResponseUtil(500,"Doctor not deleted",null);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDoctors() {
        return new ResponseUtil(200,"Get All doctors",doctorService.getAllDoctors());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDoctorById(@PathVariable int id) {
        try {
            return new ResponseUtil(200,"Get Doctor by Id",doctorService.getDoctorById(id));
        } catch (Exception e) {
            return new ResponseUtil(500,"Doctor not found",null);
        }
    }
}
