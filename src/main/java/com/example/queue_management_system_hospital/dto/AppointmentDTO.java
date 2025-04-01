package com.example.queue_management_system_hospital.dto;

import com.example.queue_management_system_hospital.entity.Appointment;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Data

public class AppointmentDTO {
    private int appointmentId;
    private Integer doctorId;
    private Integer patientId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Integer queueNumber;
    private AppointmentStatus status;  // PENDING, CONFIRMED, COMPLETED, CANCELLED
    private PaymentStatus paymentStatus;  // PENDING, PAID, REFUNDED
    private Double channelingFee;
    private String departmentName;

    public enum AppointmentStatus {
        PENDING, CONFIRMED, COMPLETED, CANCELLED
    }

    public enum PaymentStatus {
        PENDING, PAID, REFUNDED
    }

    public AppointmentDTO(Integer appointmentId, Integer doctorId, Integer patientId, LocalDate appointmentDate, LocalTime appointmentTime, Integer queueNumber, Appointment.AppointmentStatus status, Appointment.PaymentStatus paymentStatus, Double channelingFee, String departmentName) {
    }

    public AppointmentDTO(int appointmentId, Integer doctorId, Integer patientId, LocalDate appointmentDate, LocalTime appointmentTime, Integer queueNumber, AppointmentStatus status, PaymentStatus paymentStatus, Double channelingFee, String departmentName) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.queueNumber = queueNumber;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.channelingFee = channelingFee;
        this.departmentName = departmentName;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(Integer queueNumber) {
        this.queueNumber = queueNumber;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getChannelingFee() {
        return channelingFee;
    }

    public void setChannelingFee(Double channelingFee) {
        this.channelingFee = channelingFee;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentDTO that = (AppointmentDTO) o;
        return appointmentId == that.appointmentId && Objects.equals(doctorId, that.doctorId) && Objects.equals(patientId, that.patientId) && Objects.equals(appointmentDate, that.appointmentDate) && Objects.equals(appointmentTime, that.appointmentTime) && Objects.equals(queueNumber, that.queueNumber) && status == that.status && paymentStatus == that.paymentStatus && Objects.equals(channelingFee, that.channelingFee) && Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, doctorId, patientId, appointmentDate, appointmentTime, queueNumber, status, paymentStatus, channelingFee, departmentName);
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "appointmentId=" + appointmentId +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", queueNumber=" + queueNumber +
                ", status=" + status +
                ", paymentStatus=" + paymentStatus +
                ", channelingFee=" + channelingFee +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}