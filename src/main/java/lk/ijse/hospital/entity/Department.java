package lk.ijse.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    private String departmentId;
    private String departmentName;
    private String location;
    private String specialization;
    private String headOfDepartment;
    private int numberOfStaff;
    private boolean isActive;
}