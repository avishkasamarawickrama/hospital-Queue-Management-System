package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.AppointmentDTO;
import com.example.queue_management_system_hospital.service.AppointmentService;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/appointment")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAppointment(@RequestBody AppointmentDTO appointment) {
        if (appointment != null) {
            try {
                appointmentService.addAppointment(appointment);
                return new ResponseUtil(200, "Appointment Saved", null);
            } catch (Exception e) {
                return new ResponseUtil(500, "Appointment not saved", null);
            }
        } else {
            return new ResponseUtil(500, "Appointment not saved", null);
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAppointment(@RequestBody AppointmentDTO appointment) {
        if (appointment != null) {
            try {
                appointmentService.updateAppointment(appointment);
                return new ResponseUtil(200, "Appointment Updated", null);
            } catch (Exception e) {
                return new ResponseUtil(500, "Appointment not updated", null);
            }
        } else {
            return new ResponseUtil(500, "Appointment not updated", null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseUtil deleteAppointment(@PathVariable("id") int id) {
        try {
            appointmentService.deleteAppointment(id);
            return new ResponseUtil(200, "Appointment Deleted", null);
        } catch (Exception e) {
            return new ResponseUtil(500, "Appointment not deleted", null);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAppointments() {
        return new ResponseUtil(200, "Get All Appointments", appointmentService.getAllAppointments());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAppointmentById(@PathVariable int id) {
        try {
            return new ResponseUtil(200, "Get Appointment by Id", appointmentService.getAppointmentById(id));
        } catch (Exception e) {
            return new ResponseUtil(500, "Appointment not found", null);
        }
    }
}
