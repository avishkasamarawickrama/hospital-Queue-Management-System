package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.AppointmentDTO;
import com.example.queue_management_system_hospital.service.impl.AppointmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AppointmentController {
    @Autowired
    private AppointmentServiceImpl appointmentService;

    private static final Logger logger = Logger.getLogger(AppointmentController.class.getName());

}