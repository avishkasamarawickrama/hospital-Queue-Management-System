package lk.ijse.hospital.service.impl;


import lk.ijse.hospital.dto.UserDTO;
import lk.ijse.hospital.entity.User;
import lk.ijse.hospital.repo.UserRepository;
import lk.ijse.hospital.service.UserService;
import lk.ijse.hospital.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return modelMapper.map(user,UserDTO.class);
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }

    @Override
    public UserDTO searchUser(String username) {
        if (userRepository.existsByEmail(username)) {
            User user=userRepository.findByEmail(username);
            return modelMapper.map(user,UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public synchronized String generateNextUserId() {
        // Get the maximum numeric ID currently in use
        Integer maxId = userRepository.findMaxNumericUserId();

        if (maxId == null) {
            return "USR001";
        }

        // Increment and format
        return String.format("USR%03d", maxId + 1);
    }
    @Override
    public int saveUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        }

        // Generate user ID if not provided
        if (userDTO.getUid() == null || userDTO.getUid().isEmpty()) {
            userDTO.setUid(generateNextUserId());
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        // Set default role if not provided
        if (userDTO.getRole() == null || userDTO.getRole().isEmpty()) {
            userDTO.setRole("USER");
        }

        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
        return VarList.Created;
    }

    public int createUserForEntity(String email, String name, String role,
                                   String entityId, String entityType) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setName(name);
        userDTO.setRole(role);
        userDTO.setEntityId(entityId);
        userDTO.setEntityType(entityType);

        // Generate temporary password
        String tempPassword = generateTempPassword();
        userDTO.setPassword(tempPassword);

        // This will auto-generate the UID
        return saveUser(userDTO);
    }
    private String generateTempPassword() {
        // Implement proper password generation logic
        return UUID.randomUUID().toString().substring(0, 8);
    }
    @Override
    public String saveUserAndGetId(UserDTO userDTO) {
        try {
            // Generate a temporary password
            String tempPassword = generateTempPassword();
            userDTO.setPassword(tempPassword); // You might want to hash this

            // Map and save the user
            User user = modelMapper.map(userDTO, User.class);
            user = userRepository.save(user);

            // Return the generated user ID
            return user.getUid();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user: " + e.getMessage());
        }
    }


    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> modelMapper.map(value, UserDTO.class)).orElse(null);
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        if (userRepository.existsById(userDTO.getUid())) {
            User existingUser = userRepository.findById(userDTO.getUid()).orElse(null);
            if (existingUser != null) {
                // Update only the fields that should be updated
                existingUser.setName(userDTO.getName());
                existingUser.setEmail(userDTO.getEmail());
                existingUser.setRole(userDTO.getRole());

                // Only update password if it's provided
                if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
                }

                userRepository.save(existingUser);
                return VarList.OK;
            }
        }
        return VarList.Not_Found;
    }

    @Override
    public int deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return VarList.OK;
        }
        return VarList.Not_Found;
    }
}