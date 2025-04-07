package lk.ijse.hospital.service;


import lk.ijse.hospital.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
    String generateNextUserId();
    String saveUserAndGetId(UserDTO userDTO);
}