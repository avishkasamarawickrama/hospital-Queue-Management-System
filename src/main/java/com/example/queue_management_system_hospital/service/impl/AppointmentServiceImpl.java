package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.AppointmentDTO;
import com.example.queue_management_system_hospital.entity.Appointment;
import com.example.queue_management_system_hospital.entity.Doctor;
import com.example.queue_management_system_hospital.entity.Patient;
import com.example.queue_management_system_hospital.repo.AppointmentRepo;
import com.example.queue_management_system_hospital.repo.DoctorRepo;
import com.example.queue_management_system_hospital.repo.PatientRepo;
import com.example.queue_management_system_hospital.service.AppointmentService;
import com.example.queue_management_system_hospital.util.MappingUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private MappingUtil mappingUtil;

    @Override
    public void addAppointment(AppointmentDTO appointmentDTO) {
        // Fetch Doctor and Patient by their IDs
        Doctor doctor = doctorRepo.findById(appointmentDTO.getDoctorId())
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));

        Patient patient = patientRepo.findById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        // Convert DTO to Appointment entity
        Appointment appointment = mappingUtil.appointmentConvertToEntity(appointmentDTO);
        appointment.setDoctor(doctor);  // Set doctor entity
        appointment.setPatient(patient);  // Set patient entity

        // Save the appointment
        appointmentRepo.save(appointment);
    }

    @Override
    public void updateAppointment(AppointmentDTO appointmentDTO) {
        // Fetch the appointment by ID
        Optional<Appointment> appointmentOptional = appointmentRepo.findById(appointmentDTO.getAppointmentId());
        if (appointmentOptional.isPresent()) {
            // Fetch the Doctor and Patient by their IDs
            Doctor doctor = doctorRepo.findById(appointmentDTO.getDoctorId())
                    .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));

            Patient patient = patientRepo.findById(appointmentDTO.getPatientId())
                    .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

            // Convert DTO to Appointment entity and update it
            Appointment appointment = mappingUtil.appointmentConvertToEntity(appointmentDTO);
            appointment.setDoctor(doctor);  // Set doctor entity
            appointment.setPatient(patient);  // Set patient entity

            appointmentRepo.save(appointment);  // Save the updated appointment
        } else {
            throw new EntityNotFoundException("Appointment not found");
        }
    }

    @Override
    public boolean deleteAppointment(int id) {
        Optional<Appointment> appointmentOptional = appointmentRepo.findById(id);
        if (appointmentOptional.isPresent()) {
            appointmentRepo.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Appointment not found");
        }
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepo.findAll().stream()
                .map(mappingUtil::appointmentConvertToDTO)
                .toList();
    }

    @Override
    public AppointmentDTO getAppointmentById(int id) {
        Optional<Appointment> appointmentOptional = appointmentRepo.findById(id);
        if (appointmentOptional.isPresent()) {
            return mappingUtil.appointmentConvertToDTO(appointmentOptional.get()); // Correct conversion
        } else {
            throw new EntityNotFoundException("Appointment not found");
        }
    }
}
