package lk.ijse.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;  // Changed from Long

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;  // Changed from Long

    @Column(name = "gender", nullable = false)
    private String gender;  // Changed from Long

    @Column(name = "specialization", nullable = false, length = 100)
    private String specialization;

    @Column(name = "qualifications", nullable = false, length = 100)
    private String qualifications;

    @Column(name = "department_id", nullable = false)
    private String departmentId;  // Changed from Long

    @Column(name = "department_name", nullable = false)
    private String departmentName;  // Changed from Long

    @Column(name = "available_from", nullable = false)
    private LocalTime availableFrom;

    @Column(name = "available_to", nullable = false)
    private LocalTime availableTo;

    @Column(name = "channeling_fee", nullable = false)
    private Double channelingFee;

    @Column(name = "max_appointments_per_day", nullable = false)
    private Integer maxAppointmentsPerDay;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    // Method to handle String to UUID conversion
    public void setUserIdFromString(String userIdString) {
        try {
            this.userId = String.valueOf(UUID.fromString(userIdString));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format: " + userIdString);
        }
    }
}