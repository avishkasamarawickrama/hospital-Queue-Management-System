package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.AppointmentDTO;
import com.example.queue_management_system_hospital.dto.AppointmentDetailDTO;
import com.example.queue_management_system_hospital.dto.DoctorDTO;
import com.example.queue_management_system_hospital.dto.PatientDTO;
import com.example.queue_management_system_hospital.entity.Appointment;
import com.example.queue_management_system_hospital.entity.AppointmentDetail;
import com.example.queue_management_system_hospital.entity.Doctor;
import com.example.queue_management_system_hospital.entity.Patient;
import com.example.queue_management_system_hospital.repo.AppointmentRepo;
import com.example.queue_management_system_hospital.repo.AppointmentDetailRepo;
import com.example.queue_management_system_hospital.repo.DoctorRepo;
import com.example.queue_management_system_hospital.repo.PatientRepo;
import com.example.queue_management_system_hospital.service.AppointmentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Override
    @Transactional
    public void addAppointment(AppointmentDTO appointmentDTO) {

    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return null;
    }

    @Override
    public AppointmentDTO getAppointmentById(Long appointmentId) {
        // Get a specific appointment by ID
        return null;
    }

    @Override
    public void updateAppointment(Long appointmentId, AppointmentDTO appointmentDTO) {
    }

    @Override
    public void deleteAppointment(Long appointmentId) {

    }
}
