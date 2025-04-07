package lk.ijse.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private int doctorId;
    private String userId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String specialization;
    private String qualifications;
    private String departmentId;  // Changed from Long to String
    private String departmentName; // Changed from Long to String
    private LocalTime availableFrom;
    private LocalTime availableTo;
    private Double channelingFee;
    private Integer maxAppointmentsPerDay;
    private Boolean isActive;
}