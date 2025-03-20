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


    @Column(name = "appointment_date")
    private LocalDate appointment_date;

    @Column(name = "appointment_time")
    private LocalTime appointment_time;

    @Column(name ="queue_number")
    private int queue_number;

    public Appointment() {
    }
    public Appointment(int appointment_id, Patient patient, Doctor doctor, LocalDate appointment_date, LocalTime appointment_time, int queue_number) {
        this.appointment_id = appointment_id;
        this.patient = patient;
        this.doctor = doctor;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
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


    public int getQueue_number() {
        return queue_number;
    }

    public void setQueue_number(int queue_number) {
        this.queue_number = queue_number;
    }
}


