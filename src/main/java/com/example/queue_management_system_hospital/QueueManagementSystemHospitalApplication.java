package com.example.queue_management_system_hospital;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QueueManagementSystemHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueueManagementSystemHospitalApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
