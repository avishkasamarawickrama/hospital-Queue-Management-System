package com.example.queue_management_system_hospital.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    private int patient_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date date_of_birth;
    private String gender;
    private String address;
    private String phone_number;
    private String email;

    public Patient(){}

    public Patient(int patient_id, User user, Date date_of_birth, String gender, String address, String phone_number, String email) {
        this.patient_id = patient_id;
        this.user = user;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
