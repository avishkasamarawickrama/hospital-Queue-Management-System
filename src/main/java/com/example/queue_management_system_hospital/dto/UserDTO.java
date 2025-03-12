package com.example.queue_management_system_hospital.dto;

public class UserDTO {
    private int user_id;
    private String name;
    private String password;
    private int phone;
    private String role;


    public UserDTO() {
    }

    public UserDTO(int user_id, String name, String password, int phone, String role) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
