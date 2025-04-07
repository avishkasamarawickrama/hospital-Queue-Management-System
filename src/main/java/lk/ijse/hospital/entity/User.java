package lk.ijse.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "systemuser")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    @Id
    @Column(name = "uid", length = 20,nullable = false)
    private String uid;  // Changed from UUID to String

    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String role;

    @Column(name = "entity_id", length = 20)
    private String entityId; // PAT001, DOC001, ADM001, etc.

    @Column(name = "entity_type", length = 20)
    private String entityType; // PATIENT, DOCTOR, ADMIN

    // Add this if you need auto-generation
    @PrePersist
    public void generateId() {
        if (this.uid == null) {
            // Implement your ID generation logic here
            this.uid = "USR" + String.format("%03d", generateNextNumber());
        }
    }
    private int generateNextNumber() {
        // Implement logic to get next number from database
        // Could use a sequence or query max ID
        return 1; // placeholder
    }
}