package com.example.queue_management_system_hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.UUID;

@Data

public class DoctorDTO {
    private int doctorId;
    private UUID userId;
    private String fullName;
    private Integer departmentId;
    private String departmentName;
    private String specialization;
    private LocalTime availableFrom;
    private LocalTime availableTo;
    private Double channelingFee;
    private Integer maxAppointmentsPerDay;
    private Boolean isActive;
    private Integer todayAppointmentCount;  // Derived field

    public DoctorDTO() {
    }

    public DoctorDTO(int doctorId, UUID userId, String fullName, Integer departmentId, String departmentName, String specialization, LocalTime availableFrom, LocalTime availableTo, Double channelingFee, Integer maxAppointmentsPerDay, Boolean isActive, Integer todayAppointmentCount) {
        this.doctorId = doctorId;
        this.userId = userId;
        this.fullName = fullName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.specialization = specialization;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
        this.channelingFee = channelingFee;
        this.maxAppointmentsPerDay = maxAppointmentsPerDay;
        this.isActive = isActive;
        this.todayAppointmentCount = todayAppointmentCount;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public LocalTime getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalTime getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(LocalTime availableTo) {
        this.availableTo = availableTo;
    }

    public Double getChannelingFee() {
        return channelingFee;
    }

    public void setChannelingFee(Double channelingFee) {
        this.channelingFee = channelingFee;
    }

    public Integer getMaxAppointmentsPerDay() {
        return maxAppointmentsPerDay;
    }

    public void setMaxAppointmentsPerDay(Integer maxAppointmentsPerDay) {
        this.maxAppointmentsPerDay = maxAppointmentsPerDay;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getTodayAppointmentCount() {
        return todayAppointmentCount;
    }

    public void setTodayAppointmentCount(Integer todayAppointmentCount) {
        this.todayAppointmentCount = todayAppointmentCount;
    }
}