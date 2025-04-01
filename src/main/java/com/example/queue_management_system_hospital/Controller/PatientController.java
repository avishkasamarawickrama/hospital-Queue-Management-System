package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.PatientDTO;
import com.example.queue_management_system_hospital.service.PatientService;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/patient")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePatient(@RequestBody PatientDTO patient) {
        if (patient != null) {
            try {
                patientService.addPatient(patient);
                return new ResponseUtil(200,"Patient Saved",null);
            } catch (Exception e) {
                return new ResponseUtil(500,"Patient not saved",null);
            }
        } else {
            return new ResponseUtil(500,"Patient not saved",null);
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updatePatient(@RequestBody PatientDTO patient) {
        if (patient != null) {
            try {
                patientService.updatePatient(patient);
                return new ResponseUtil(200,"Patient Updated",null);
            } catch (Exception e) {
                return new ResponseUtil(500,"Patient not updated",null);
            }
        } else {
            return new ResponseUtil(500,"Patient not updated",null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseUtil deletePatient(@PathVariable("id") int id) {
        try {
            patientService.deletePatient(id);
            return new ResponseUtil(200,"Patient Deleted",null);
        } catch (Exception e) {
            return new ResponseUtil(500,"Patient not deleted",null);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPatients() {
        return new ResponseUtil(200,"Get All patients",patientService.getAllPatients());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getPatientById(@PathVariable int id) {
        try {
            return new ResponseUtil(200,"Get Patient by Id",patientService.getPatientById(id));
        } catch (Exception e) {
            return new ResponseUtil(500,"Patient not found",null);
        }
    }
}
