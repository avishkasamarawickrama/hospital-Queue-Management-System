package com.example.queue_management_system_hospital.dto;

import jakarta.persistence.Id;

public class AppointmentDetailDTO {
    @Id
    private Long detailId;
    private String procedure;
    private String notes;
    private int appointment_id;

    public AppointmentDetailDTO() {

    }

    public AppointmentDetailDTO(Long detailId, String procedure, String notes,int appointment_id) {
        this.detailId = detailId;
        this.procedure = procedure;
        this.notes = notes;
        this.appointment_id = appointment_id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
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
