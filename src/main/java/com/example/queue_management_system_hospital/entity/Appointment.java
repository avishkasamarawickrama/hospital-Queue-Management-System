package com.example.queue_management_system_hospital.entity;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointment_id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "appointment_date")
    private LocalDate appointment_date;

    @Column(name = "appointment_time")
    private LocalTime appointment_time;

//    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private String status;

//    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private String priority;

    @Column(name ="queue_number")
    private int queue_number;

    public Appointment() {
    }
    public Appointment(int appointment_id, Patient patient, Doctor doctor, Department department, LocalDate appointment_date, LocalTime appointment_time, String status, String priority, int queue_number) {
        this.appointment_id = appointment_id;
        this.patient = patient;
        this.doctor = doctor;
        this.department = department;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.status = status;
        this.priority = priority;
        this.queue_number = queue_number;}

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(LocalDate appoinment_date) {
        this.appointment_date = appoinment_date;
    }

    public LocalTime getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(LocalTime appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getQueue_number() {
        return queue_number;
    }

    public void setQueue_number(int queue_number) {
        this.queue_number = queue_number;
    }
}


