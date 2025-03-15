package com.example.queue_management_system_hospital.entity;

import jakarta.persistence.*;

import java.sql.Time;

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

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private String specialization;
    private Time available_from;
    private Time available_to;

    public Doctor() {
    }

    public Doctor(int doctor_id,String doctor_name, User user,Department department, String specialization, Time available_from, Time available_to) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.user = user;
        this.department = department;
        this.specialization = specialization;
        this.available_from = available_from;
        this.available_to = available_to;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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


}
