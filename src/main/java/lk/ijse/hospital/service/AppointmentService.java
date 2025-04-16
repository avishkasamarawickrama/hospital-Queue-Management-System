package lk.ijse.hospital.service;

import lk.ijse.hospital.dto.AppointmentDTO;
import lk.ijse.hospital.entity.Appointment;
import lk.ijse.hospital.util.ResponseUtil;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    ResponseUtil saveAppointment(AppointmentDTO appointmentDTO);
    ResponseUtil updateAppointment(AppointmentDTO appointmentDTO);
    ResponseUtil deleteAppointment(Integer appointmentId);
    ResponseUtil getAllAppointments();
    ResponseUtil getAppointmentById(Integer appointmentId);
    ResponseUtil getAppointmentsByDate(LocalDate date);
    ResponseUtil getAppointmentsByDoctorAndDate(Integer doctorId, LocalDate date);
    ResponseUtil getAppointmentsByPatient(String patientId);
    ResponseUtil getNextAppointmentId();
    ResponseUtil getAvailableTimeSlots(Integer doctorId, LocalDate date);

    // Add this new method
    ResponseUtil filterAppointments(LocalDate date, Integer doctorId, String status);

    Appointment updateAppointmentStatus(Integer appointmentId, String status, String paymentStatus);
}
