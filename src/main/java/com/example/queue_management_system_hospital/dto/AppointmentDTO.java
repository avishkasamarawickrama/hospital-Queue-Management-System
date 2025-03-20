package com.example.queue_management_system_hospital.dto;

import jakarta.persistence.Id;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class AppointmentDTO {
    @Id
    private int appointment_id;
    private int patient_id;
    private int doctor_id;
    private LocalDate appointment_date;
    private LocalTime appointment_time;
    private int queue_number;
    private List<AppointmentDetailDTO> appointmentDetails;  // Optional: if you have details for the appointment

    public AppointmentDTO() {
    }

    public AppointmentDTO(int appointment_id, int patient_id, int doctor_id, int department_id, LocalDate appointment_date, LocalTime appointment_time, String status, String priority, int queue_number, List<AppointmentDetailDTO> appointmentDetails) {
        this.appointment_id = appointment_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;

        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;

        this.queue_number = queue_number;
        this.appointmentDetails = appointmentDetails;
    }

    public List<AppointmentDetailDTO> getAppointmentDetails() {
        return appointmentDetails;
    }

    public void setAppointmentDetails(List<AppointmentDetailDTO> appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(LocalDate appointment_date) {
        this.appointment_date = appointment_date;
    }

    public LocalTime getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(LocalTime appointment_time) {
        this.appointment_time = appointment_time;
    }


    public int getQueue_number() {
        return queue_number;
    }

    public void setQueue_number(int queue_number) {
        this.queue_number = queue_number;
    }
}
