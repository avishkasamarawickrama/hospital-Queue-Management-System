package lk.ijse.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String uid;  // Added this field
    private String email;
    private String password;
    private String name;
    private String role;
    private String entityId;  // Optional: for linking to patient/doctor/admin
    private String entityType; // Optional: "PATIENT", "DOCTOR", "ADMIN"
}