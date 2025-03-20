package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    void addAppointment(AppointmentDTO appointmentDTO);
    List<AppointmentDTO> getAllAppointments();
    AppointmentDTO getAppointmentById(Long appointmentId);
    void updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO);
    void deleteAppointment(Long appointmentId);
}
