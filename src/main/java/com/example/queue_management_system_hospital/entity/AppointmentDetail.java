package com.example.queue_management_system_hospital.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "appointment_details")
public class AppointmentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
    private String procedure;
    private String notes;

    public AppointmentDetail() {
    }

    public AppointmentDetail(Long detailId, Appointment appointment, String procedure, String notes) {
        this.detailId = detailId;
        this.appointment = appointment;
        this.procedure = procedure;
        this.notes = notes;
    }
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
