package com.example.queue_management_system_hospital.dto;

import java.util.Date;

public class PatientDTO {
    private int patient_id;
    private int user_id;
    private Date date_of_birth;
    private String gender;
    private String address;
    private String phone_number;
    private String email;

    public PatientDTO() {

    }

    public PatientDTO(int patient_id, int user_id, Date date_of_birth, String gender, String address, String phone_number, String email) {
        this.patient_id = patient_id;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
