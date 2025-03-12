package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.PatientDTO;
import com.example.queue_management_system_hospital.service.impl.PatientServiceImpl;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/patient")
@CrossOrigin(origins ="*")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping(path = "save")
    public ResponseUtil getPatient(@RequestBody PatientDTO patientDTO) {
        {
            patientService.save(patientDTO);
            return new ResponseUtil(201, "Patient is saved", null);
        }

    }
    @GetMapping("/{id}")
    public ResponseUtil getPatientById(@PathVariable int id){
        return new ResponseUtil(200,"Patient is found",patientService.getById(id));
    }
    @PutMapping(path = "update")
    public ResponseUtil updatePatient(@RequestBody PatientDTO patientDTO){
        patientService.update(patientDTO);
        return new ResponseUtil(200,"Patient is updated",null);
    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deletePatient(@PathVariable int id){
        patientService.delete(id);
        return new ResponseUtil(200,"Patient is deleted",null);
    }
}
