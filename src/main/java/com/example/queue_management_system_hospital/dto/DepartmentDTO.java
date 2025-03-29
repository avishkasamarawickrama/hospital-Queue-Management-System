package com.example.queue_management_system_hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class DepartmentDTO {
    private int departmentId;
    private String departmentName;
    private String description;
    private String location;

    public DepartmentDTO() {
    }

    public DepartmentDTO(int departmentId, String departmentName, String description, String location) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.description = description;
        this.location = location;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}