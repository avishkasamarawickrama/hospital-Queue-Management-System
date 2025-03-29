package com.example.queue_management_system_hospital.repo;

import com.example.queue_management_system_hospital.entity.AppointmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AppointmentDetailRepo extends JpaRepository<AppointmentDetail, Integer> {}
