package lk.ijse.hospital.dto;

import lk.ijse.hospital.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentStatusUpdateRequest {
    private String status;
    private String paymentStatus;

    // Add validation method
    public boolean isValid() {
        try {
            Appointment.AppointmentStatus.valueOf(status);
            Appointment.PaymentStatus.valueOf(paymentStatus);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}