package com.example.queue_management_system_hospital.dto;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class DoctorDTO {
    private int doctor_id;
    private String doctor_name;
    private int user_id;

    private int department_id;

    private LocalTime available_from;
    private LocalTime available_to;

    private Double channeling_pay;
    private List<AppointmentDTO>appointmentDTO;

    public DoctorDTO() {
    }

    public DoctorDTO(int doctor_id,String doctor_name, int user_id,int department_id, String specialization, LocalTime available_from, LocalTime available_to,double channeling_pay,List<AppointmentDTO>appointmentDTO) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.user_id = user_id;
        this.department_id = department_id;
        this.available_from = available_from;
        this.available_to = available_to;
        this.channeling_pay = channeling_pay;
        this.appointmentDTO = appointmentDTO;
    }

    public Double getChanneling_pay() {
        return channeling_pay;
    }

    public void setChanneling_pay(Double channeling_pay) {
        this.channeling_pay = channeling_pay;
    }

    public List<AppointmentDTO> getAppointmentDTO() {
        return appointmentDTO;
    }

    public void setAppointmentDTO(List<AppointmentDTO> appointmentDTO) {
        this.appointmentDTO = appointmentDTO;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public LocalTime getAvailable_from() {
        return available_from;
    }

    public void setAvailable_from(LocalTime available_from) {
        this.available_from = available_from;
    }

    public LocalTime getAvailable_to() {
        return available_to;
    }

    public void setAvailable_to(LocalTime available_to) {
        this.available_to = available_to;
    }
}
