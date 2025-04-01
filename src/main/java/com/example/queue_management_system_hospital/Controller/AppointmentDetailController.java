package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.AppointmentDetailDTO;
import com.example.queue_management_system_hospital.service.AppointmentDetailService;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/appointment-detail")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AppointmentDetailController {

    @Autowired
    private AppointmentDetailService appointmentDetailService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAppointmentDetail(@RequestBody AppointmentDetailDTO appointmentDetail) {
        if (appointmentDetail != null) {
            try {
                appointmentDetailService.addAppointmentDetail(appointmentDetail);
                return new ResponseUtil(200, "Appointment detail saved", null);
            } catch (Exception e) {
                return new ResponseUtil(500, "Appointment detail not saved", null);
            }
        } else {
            return new ResponseUtil(500, "Appointment detail not saved", null);
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAppointmentDetail(@RequestBody AppointmentDetailDTO appointmentDetail) {
        if (appointmentDetail != null) {
            try {
                appointmentDetailService.updateAppointmentDetail(appointmentDetail);
                return new ResponseUtil(200, "Appointment detail updated", null);
            } catch (Exception e) {
                return new ResponseUtil(500, "Appointment detail not updated", null);
            }
        } else {
            return new ResponseUtil(500, "Appointment detail not updated", null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseUtil deleteAppointmentDetail(@PathVariable("id") int id) {
        try {
            appointmentDetailService.deleteAppointmentDetail(id);
            return new ResponseUtil(200, "Appointment detail deleted", null);
        } catch (Exception e) {
            return new ResponseUtil(500, "Appointment detail not deleted", null);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAppointmentDetails() {
        return new ResponseUtil(200, "Get all appointment details", appointmentDetailService.getAllAppointmentDetails());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAppointmentDetailById(@PathVariable int id) {
        try {
            return new ResponseUtil(200, "Get appointment detail by Id", appointmentDetailService.getAppointmentDetailById(id));
        } catch (Exception e) {
            return new ResponseUtil(500, "Appointment detail not found", null);
        }
    }
}
