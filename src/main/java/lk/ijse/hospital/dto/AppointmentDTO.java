package lk.ijse.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Integer appointmentId;
    private Integer doctorId;
    private String doctorName;
    private String patientId;
    private String patientName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Integer queueNumber;
    private AppointmentStatus status;
    private PaymentStatus paymentStatus;
    private Double channelingFee;
    private String departmentName;
    private String patientContact;
    public enum AppointmentStatus {
        PENDING, CONFIRMED, COMPLETED, CANCELLED
    }

    public enum PaymentStatus {
        PENDING, PAID, REFUNDED
    }
}