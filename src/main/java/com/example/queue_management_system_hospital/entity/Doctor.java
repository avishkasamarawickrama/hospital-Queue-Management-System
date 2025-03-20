package com.example.queue_management_system_hospital.entity;

import com.example.queue_management_system_hospital.dto.DoctorDTO;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctor_id;

    private String doctor_name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Department department;

    private String specialization;
    private Time available_from;
    private Time available_to;

    private Double Channeling_pay;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(int doctor_id,String doctor_name, User user, String specialization, Time available_from, Time available_to, Double channeling_pay, List<Appointment> appointments) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.user = user;
        this.specialization = specialization;
        this.available_from = available_from;
        this.available_to = available_to;
        Channeling_pay = channeling_pay;
        this.appointments = appointments;
    }


    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

     public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Time getAvailable_from() {
        return available_from;
    }

    public void setAvailable_from(Time available_from) {
        this.available_from = available_from;
    }

    public Time getAvailable_to() {
        return available_to;
    }

    public void setAvailable_to(Time available_to) {
        this.available_to = available_to;
    }

    public Double getChanneling_pay() {
        return Channeling_pay;
    }

    public void setChanneling_pay(Double channeling_pay) {
        Channeling_pay = channeling_pay;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
