package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.AppointmentDTO;
import com.example.queue_management_system_hospital.entity.Appointment;
import com.example.queue_management_system_hospital.entity.Doctor;
import com.example.queue_management_system_hospital.entity.Patient;
import com.example.queue_management_system_hospital.repo.*;
import com.example.queue_management_system_hospital.service.AppointmentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void appointment(AppointmentDTO appointmentDTO) {
        // Find patient by ID
        Patient patient = patientRepo.findById(appointmentDTO.getPatient_id())
                .orElseThrow(() -> new RuntimeException("Patient not found!"));

        // Find doctor by ID
        Doctor doctor = doctorRepo.findById(appointmentDTO.getDoctor_id())
                .orElseThrow(() -> new RuntimeException("Doctor not found!"));

        // Map DTO to entity
        Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointment_date(LocalDate.now()); // Store current date

        // Save appointment
        appointmentRepo.save(appointment);
    }
}
