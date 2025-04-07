package lk.ijse.hospital.controller;

import lk.ijse.hospital.dto.DoctorDTO;
import lk.ijse.hospital.service.DoctorService;
import lk.ijse.hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*")
@RequestMapping("api/v1/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("nextUserId")
    public ResponseUtil getNextUserId() {
        return new ResponseUtil(200, "Next User ID", doctorService.generateNextUserId());
    }
    @PostMapping("save")
    public ResponseUtil saveDoctor(@RequestBody DoctorDTO doctorDTO) {
        try {
            doctorService.addDoctor(doctorDTO);
            return new ResponseUtil(201, "Doctor Saved", null);
        } catch (IllegalArgumentException e) {
            return new ResponseUtil(400, e.getMessage(), null);
        } catch (Exception e) {
            return new ResponseUtil(500, "Error saving doctor", null);
        }
    }

    @PutMapping("update")
    public ResponseUtil updateDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.updateDoctor(doctorDTO);
        return new ResponseUtil(200, "Doctor Updated", null);
    }

    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return new ResponseUtil(200, "Doctor Deleted", null);
    }

    @GetMapping("getAll")
    public ResponseUtil getAllDoctors() {
        return new ResponseUtil(200, "Doctor List", doctorService.getAllDoctors());
    }

    @GetMapping("getDoctorIds")
    public ResponseUtil getDoctorIds() {
        return new ResponseUtil(200, "Doctor ID List", doctorService.getDoctorIds());
    }

    @GetMapping("getDoctorById/{id}")
    public ResponseUtil getDoctorById(@PathVariable int id) {
        return new ResponseUtil(200, "Doctor Found", doctorService.getDoctorById(id));
    }
}