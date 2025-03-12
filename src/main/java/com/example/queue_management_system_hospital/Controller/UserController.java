package com.example.queue_management_system_hospital.Controller;

import com.example.queue_management_system_hospital.dto.UserDTO;
import com.example.queue_management_system_hospital.service.impl.UserServiceImpl;
import com.example.queue_management_system_hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping(path ="save")
    public ResponseUtil getUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);

        return new ResponseUtil(201,"user is saved",null);

    }

    @GetMapping(path ="getAll")
    public ResponseUtil getUsers() {
        return new ResponseUtil(200,"Item list",userService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseUtil getById(@PathVariable int id) {
        return new ResponseUtil(200, "Success", userService.getById(id));
    }
    @PutMapping(path = "update")
    public ResponseUtil updateUser(@RequestBody UserDTO userDTO) {
        userService.update(userDTO);

        return new ResponseUtil(200,"user is updated",null);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteUser(@PathVariable int id) {
        userService.delete(id);
        return new ResponseUtil(200,"user is deleted",null);
    }
}
