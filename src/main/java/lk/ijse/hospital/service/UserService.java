package lk.ijse.hospital.service;


import lk.ijse.hospital.dto.UserDTO;

import java.util.List;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
    String generateNextUserId();
    String saveUserAndGetId(UserDTO userDTO);


    List<UserDTO> getAllUsers();
    UserDTO getUserById(String id);
    int updateUser(UserDTO userDTO);
    int deleteUser(String id);
}