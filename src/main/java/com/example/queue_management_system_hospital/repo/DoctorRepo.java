package com.example.queue_management_system_hospital.repo;

import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    @Query("SELECT d.doctor_id From Doctor d")
    List<Integer> getDoctorsId();

    @Query("SELECT d.doctor_id FROM Doctor d WHERE d.doctor_id = :id")
    DoctorDTO findNameById(@Param("id") int id);
}
