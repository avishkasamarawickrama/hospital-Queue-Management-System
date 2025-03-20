package com.example.queue_management_system_hospital.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin("*")
public class AdminController {

    @GetMapping("/checkRole")
    public String checkRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .findFirst()
                .orElse("UNKNOWN");

        return "{\"role\": \"" + role + "\"}";
    }

    @GetMapping("/test1")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String check(){
        return "you are Admin :-)";
    }

    @GetMapping("/test2")
    @PreAuthorize("hasAuthority('USER')")
    public String checks(){
        return "you are User :-)";
    }
}