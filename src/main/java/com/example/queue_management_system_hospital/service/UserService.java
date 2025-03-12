package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.UserDTO;

import java.util.List;

public interface UserService {
    void save(UserDTO userDTO);

    UserDTO getById(int id);

    List<UserDTO> getAll();
    void update(UserDTO userDTO);
    void delete (int id);
}
