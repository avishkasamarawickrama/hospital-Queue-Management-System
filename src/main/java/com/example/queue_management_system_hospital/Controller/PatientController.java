package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.PatientDTO;
import com.example.queue_management_system_hospital.service.impl.PatientServiceImpl;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/patient")
@CrossOrigin(origins = "http://localhost:63342",allowedHeaders = "*")

public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping( "save")
    public ResponseUtil savePatient(@RequestBody PatientDTO patientDTO) {
        patientService.addPatient(patientDTO);
        return new ResponseUtil(201,"patient Saved",null);
    }

    @PutMapping("update")
    public ResponseUtil updatePatient(@RequestBody PatientDTO patientDTO) {
        patientService.updatePatient(patientDTO);
        return new ResponseUtil(200,"patient Updated",null);

    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deletePatient(@PathVariable("id") int id) {
        patientService.deletePatient(id);
        return new ResponseUtil(200,"patient Deleted",null);
    }
    @GetMapping("getAll")
    public ResponseUtil getAllPatients() {
        return new ResponseUtil(
                200,
                "patient List",
                patientService.getAllPatients());
    }
    @GetMapping("getPatientId")
    public ResponseUtil getPatientsId() {
        return new ResponseUtil(
                200,
                "Patient id List",
                patientService.getPatientsId());
    }
    @GetMapping("getPatientById/{id}")
    public ResponseUtil getPatientById(@PathVariable int id) {
        PatientDTO patient = patientService.getPatientById(id);
        return new ResponseUtil(200, "patient Found", patient);

    }
}
