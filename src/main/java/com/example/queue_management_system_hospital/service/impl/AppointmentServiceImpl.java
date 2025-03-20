package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.AppointmentDTO;
import com.example.queue_management_system_hospital.dto.AppointmentDetailDTO;
import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.dto.PatientDTO;
import com.example.queue_management_system_hospital.entity.Appointment;
import com.example.queue_management_system_hospital.entity.AppointmentDetail;
import com.example.queue_management_system_hospital.entity.Doctor;
import com.example.queue_management_system_hospital.entity.Patient;
import com.example.queue_management_system_hospital.repo.AppointmentRepo;
import com.example.queue_management_system_hospital.repo.AppointmentDetailRepo;
import com.example.queue_management_system_hospital.repo.DoctorRepo;
import com.example.queue_management_system_hospital.repo.PatientRepo;
import com.example.queue_management_system_hospital.service.AppointmentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private AppointmentDetailRepo appointmentDetailRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void addAppointment(AppointmentDTO appointmentDTO) {
        // Create and save the appointment entity
        Appointment appointment = new Appointment();
        appointment.setQueue_number(appointmentDTO.getQueue_number());
        appointment.setAppointment_date(appointmentDTO.getAppointment_date());

        // Fetch patient details from the patientRepo
        Patient patient = patientRepo.findById(appointmentDTO.getPatient_id())
                .orElseThrow(() -> new RuntimeException("Patient not found: " + appointmentDTO.getPatient_id()));
        appointment.setPatient(patient);

        // Fetch doctor details from the doctorRepo
        Doctor doctor = doctorRepo.findById(appointmentDTO.getDoctor_id())
                .orElseThrow(() -> new RuntimeException("Doctor not found: " + appointmentDTO.getDoctor_id()));
        appointment.setDoctor(doctor);

        // Save the appointment
        Appointment savedAppointment = appointmentRepo.save(appointment);

        // Handle appointment details (if applicable)
        List<AppointmentDetailDTO> appointmentDetailsList = appointmentDTO.getAppointmentDetails();
        for (AppointmentDetailDTO appointmentDetailDTO : appointmentDetailsList) {
            AppointmentDetail appointmentDetail = new AppointmentDetail();
            appointmentDetail.setAppointment(savedAppointment);
            appointmentDetail.setProcedure(appointmentDetailDTO.getProcedure());
            appointmentDetail.setNotes(appointmentDetailDTO.getNotes());

            // Save each appointment detail
            appointmentDetailRepo.save(appointmentDetail);
        }
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        // Get all appointments and convert them into AppointmentDTO
        List<Appointment> appointments = appointmentRepo.findAll();
        return modelMapper.map(appointments, new TypeToken<List<AppointmentDTO>>() {}.getType());
    }

    @Override
    public AppointmentDTO getAppointmentById(Long appointmentId) {
        // Get a specific appointment by ID
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found: " + appointmentId));
        return modelMapper.map(appointment, AppointmentDTO.class);
    }

    @Override
    public void updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO) {
        // Fetch the existing appointment from the database
        Appointment existingAppointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found: " + appointmentId));

        // Update appointment details
        existingAppointment.setQueue_number(appointmentDTO.getQueue_number());
        existingAppointment.setAppointment_date(appointmentDTO.getAppointment_date());

        // Fetch patient details and update
        Patient patient = patientRepo.findById(appointmentDTO.getPatient_id())
                .orElseThrow(() -> new RuntimeException("Patient not found: " + appointmentDTO.getPatient_id()));
        existingAppointment.setPatient(patient);

        // Fetch doctor details and update
        Doctor doctor = doctorRepo.findById(appointmentDTO.getDoctor_id())
                .orElseThrow(() -> new RuntimeException("Doctor not found: " + appointmentDTO.getDoctor_id()));
        existingAppointment.setDoctor(doctor);

        // Save the updated appointment
        appointmentRepo.save(existingAppointment);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        // Check if the appointment exists
        Appointment existingAppointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found: " + appointmentId));

        // Delete the appointment
        appointmentRepo.delete(existingAppointment);
    }

    // Additional methods can be added for updating or deleting appointments
}
