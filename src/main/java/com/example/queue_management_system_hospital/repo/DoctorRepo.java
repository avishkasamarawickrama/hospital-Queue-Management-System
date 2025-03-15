package com.example.queue_management_system_hospital.repo;

import com.example.queue_management_system_hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
}
