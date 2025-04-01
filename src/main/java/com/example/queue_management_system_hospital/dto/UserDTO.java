package com.example.queue_management_system_hospital.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Data
@Component
public class UserDTO {
    private UUID userId;
//    @Email(message = "Invalid email format")
    private String email;
    private String fullName;
    private UserRole role;  // ADMIN, DOCTOR, PATIENT, STAFF
//    @NotBlank(message = "Password is required")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "Invalid password format")
     private String password;

    public enum UserRole {
        ADMIN, DOCTOR, PATIENT, STAFF
    }

    public UserDTO() {
    }

    public UserDTO(UUID userId, String email, String fullName, UserRole role, String password) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}