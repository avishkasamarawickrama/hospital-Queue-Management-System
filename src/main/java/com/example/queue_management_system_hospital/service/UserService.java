package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.UserDTO;



public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
}
