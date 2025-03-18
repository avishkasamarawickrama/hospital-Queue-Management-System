package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.service.impl.DoctorServiceImpl;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/doctor")
@CrossOrigin(origins = "http://localhost:63342",allowedHeaders = "*")

public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService ;

    @PostMapping( "save")
    public ResponseUtil saveDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.addDoctor(doctorDTO);
        return new ResponseUtil(201,"Doctor Saved",null);
    }

    @PutMapping("update")
    public ResponseUtil updateDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.updateDoctor(doctorDTO);
        return new ResponseUtil(200,"Doctor Updated",null);

    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteDoctor(@PathVariable("id") int id) {
        doctorService.deleteDoctor(id);
        return new ResponseUtil(200,"Doctor Deleted",null);
    }
    @GetMapping("getAll")
    public ResponseUtil getAllDoctors() {
        return new ResponseUtil(
                200,
                "Doctor List",
                doctorService.getAllDoctors());
    }
    @GetMapping("getCustomerId")
    public ResponseUtil getDoctorsId() {
        return new ResponseUtil(
                200,
                "doctor id List",
                doctorService.getDoctorsId());
    }
    @GetMapping("getDoctorById/{id}")
    public ResponseUtil getDoctorById(@PathVariable int id) {
        DoctorDTO doctor = doctorService.getDoctorById(id);
        return new ResponseUtil(200, "Doctor Found", doctor);

    }
}
