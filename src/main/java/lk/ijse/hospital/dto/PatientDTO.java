package lk.ijse.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String patientId;
    private String userId;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String emergencyContact;
    private String bloodGroup;
    private String medicalHistory;
    private String allergies;
    private String currentMedications;
    private String insuranceProvider;
    private String insurancePolicyNumber;
}