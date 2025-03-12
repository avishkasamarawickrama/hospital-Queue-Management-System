package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.UserDTO;

import com.example.queue_management_system_hospital.entity.User;
import com.example.queue_management_system_hospital.repo.UserRepo;
import com.example.queue_management_system_hospital.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public void save(UserDTO userDTO){
        if (userRepo.existsById(userDTO.getUser_id()));
        userRepo.save(modelMapper.map(userDTO, User.class));
        throw new RuntimeException("user already exists");
    }
    @Override
    public UserDTO getById(int id){
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()){
            return modelMapper.map(optionalUser.get(),UserDTO.class);

        }
        throw new RuntimeException("patient not found ");
    }
    public List<UserDTO> getAll(){
        return modelMapper.map(
                userRepo.findAll(),
                new TypeToken<List<UserDTO>>(){}.getType()
        );
    }
    public void update(UserDTO userDTO){
        if (userRepo.existsById(userDTO.getUser_id())){
            userRepo.save(
                    modelMapper.map(userDTO,User.class)
            );
        }
        throw new RuntimeException("user doesn't exists");
    }
    public void delete(int id){
        if (userRepo.existsById(id)){
            userRepo.deleteById(id);
        }
        throw new RuntimeException("user doesn't exists");
    }
}
