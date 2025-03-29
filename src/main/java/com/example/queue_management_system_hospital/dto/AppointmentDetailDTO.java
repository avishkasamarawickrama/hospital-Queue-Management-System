package com.example.queue_management_system_hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class AppointmentDetailDTO {
    private int appDetailsId;
    private Long appointmentId;
    private String procedureName;
    private String notes;
    private String diagnosis;
    private String prescription;

    public AppointmentDetailDTO() {
    }

    public AppointmentDetailDTO(int appDetailsId, Long appointmentId, String procedureName, String notes, String diagnosis, String prescription) {
        this.appDetailsId = appDetailsId;
        this.appointmentId = appointmentId;
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

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
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

    @Override
    public String toString() {
        return "AppointmentDetailDTO{" +
                "appDetailsId=" + appDetailsId +
                ", appointmentId=" + appointmentId +
                ", procedureName='" + procedureName + '\'' +
                ", notes='" + notes + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                '}';
    }
}