package lk.ijse.hospital.controller;

import lk.ijse.hospital.dto.PatientDTO;
import lk.ijse.hospital.service.PatientService;
import lk.ijse.hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*")
@RequestMapping("api/v1/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("nextPatientId")
    public ResponseUtil getNextPatientId() {
        return new ResponseUtil(200, "Next Patient ID", patientService.generateNextPatientId());
    }

    @GetMapping("nextUserId")
    public ResponseUtil getNextUserId() {
        return new ResponseUtil(200, "Next User ID", patientService.generateNextUserId());
    }

    @PostMapping("save")
    public ResponseUtil savePatient(@RequestBody PatientDTO patientDTO) {
        try {
            patientService.addPatient(patientDTO);
            return new ResponseUtil(201, "Patient Saved", null);
        } catch (IllegalArgumentException e) {
            return new ResponseUtil(400, e.getMessage(), null);
        } catch (Exception e) {
            return new ResponseUtil(500, "Error saving patient", null);
        }
    }

    @PutMapping("update")
    public ResponseUtil updatePatient(@RequestBody PatientDTO patientDTO) {
        patientService.updatePatient(patientDTO);
        return new ResponseUtil(200, "Patient Updated", null);
    }

    @DeleteMapping("delete/{id}")
    public ResponseUtil deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
        return new ResponseUtil(200, "Patient Deleted", null);
    }

    @GetMapping("getAll")
    public ResponseUtil getAllPatients() {
        return new ResponseUtil(200, "Patient List", patientService.getAllPatients());
    }

    @GetMapping("getPatientById/{id}")
    public ResponseUtil getPatientById(@PathVariable String id) {
        return new ResponseUtil(200, "Patient Found", patientService.getPatientById(id));
    }
}