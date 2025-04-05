package lk.ijse.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private String departmentId;
    private String departmentName;
    private String location;
    private String specialization;
    private String headOfDepartment;
    private int numberOfStaff;
    private boolean isActive;
}