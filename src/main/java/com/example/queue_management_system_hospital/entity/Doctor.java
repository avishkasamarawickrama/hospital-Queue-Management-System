package com.example.queue_management_system_hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;


@Data
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "available_from")
    private LocalTime availableFrom;

    @Column(name = "available_to")
    private LocalTime availableTo;

    @Column(name = "channeling_fee", nullable = false)
    private Double channelingFee;

    @Column(name = "max_appointments_per_day")
    private Integer maxAppointmentsPerDay;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @Column(name = "is_active")
    private Boolean isActive = true;

    public Doctor() {
    }

    public Doctor(int doctorId, User user, Department department, String specialization, LocalTime availableFrom, LocalTime availableTo, Double channelingFee, Integer maxAppointmentsPerDay, List<Appointment> appointments, Boolean isActive) {
        this.doctorId = doctorId;
        this.user = user;
        this.department = department;
        this.specialization = specialization;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
        this.channelingFee = channelingFee;
        this.maxAppointmentsPerDay = maxAppointmentsPerDay;
        this.appointments = appointments;
        this.isActive = isActive;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}