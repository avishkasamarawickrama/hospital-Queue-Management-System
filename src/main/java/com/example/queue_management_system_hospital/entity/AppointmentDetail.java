package com.example.queue_management_system_hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "appointment_details")
public class AppointmentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appDetailsId;

    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

    @Column(name = "procedure_name")
    private String procedureName;

    @Column(name = "notes", length = 1000)
    private String notes;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "prescription", length = 2000)
    private String prescription;

    public AppointmentDetail() {
    }

    public AppointmentDetail(int appDetailsId, Appointment appointment, String procedureName, String notes, String diagnosis, String prescription) {
        this.appDetailsId = appDetailsId;
        this.appointment = appointment;
        this.procedureName = procedureName;
        this.notes = notes;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public int getAppDetailsId() {
        return appDetailsId;
    }

    public void setAppDetailsId(int appDetailsId) {
        this.appDetailsId = appDetailsId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}