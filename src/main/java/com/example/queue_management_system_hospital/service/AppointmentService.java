package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.AppointmentDTO;
import com.example.queue_management_system_hospital.dto.DepartmentDTO;

import java.util.List;

public interface AppointmentService {
    void addAppointment(AppointmentDTO appointment);
    void updateAppointment(AppointmentDTO appointment);
    boolean deleteAppointment(int id);
    List<AppointmentDTO> getAllAppointments();
    AppointmentDTO getAppointmentById(int id);
}
