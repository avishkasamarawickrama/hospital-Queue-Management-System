package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.AppointmentDTO;
import com.example.queue_management_system_hospital.service.impl.AppointmentServiceImpl;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AppointmentController {
    @Autowired
    private AppointmentServiceImpl appointmentService;

    @PostMapping("save")
    public ResponseUtil saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.addAppointment(appointmentDTO);
        return new ResponseUtil(201,"Appointment Saved",null);
    }

    @GetMapping("getAll")
    public ResponseUtil getAllAppointment() {
        return new ResponseUtil(200,"All Orders",appointmentService.getAllAppointments());
    }
}