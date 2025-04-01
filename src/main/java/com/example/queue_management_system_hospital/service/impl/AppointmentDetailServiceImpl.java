package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.AppointmentDetailDTO;
import com.example.queue_management_system_hospital.entity.Appointment;
import com.example.queue_management_system_hospital.entity.AppointmentDetail;
import com.example.queue_management_system_hospital.repo.AppointmentDetailRepo;
import com.example.queue_management_system_hospital.repo.AppointmentRepo;
import com.example.queue_management_system_hospital.service.AppointmentDetailService;
import com.example.queue_management_system_hospital.util.MappingUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentDetailServiceImpl implements AppointmentDetailService {

    @Autowired
    private AppointmentDetailRepo appointmentDetailRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private MappingUtil mappingUtil;

    @Override
    public void addAppointmentDetail(AppointmentDetailDTO appointmentDetailDTO) {
        // Fetch the Appointment by ID
        Appointment appointment = appointmentRepo.findById(appointmentDetailDTO.getAppointmentId())
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found"));

        // Convert DTO to AppointmentDetail entity
        AppointmentDetail appointmentDetail = mappingUtil.appointmentDetailConvertToEntity(appointmentDetailDTO);
        appointmentDetail.setAppointment(appointment); // Set the appointment entity

        // Save the appointment detail
        appointmentDetailRepo.save(appointmentDetail);
    }

    @Override
    public void updateAppointmentDetail(AppointmentDetailDTO appointmentDetailDTO) {
        // Fetch the AppointmentDetail by ID
        Optional<AppointmentDetail> detailOptional = appointmentDetailRepo.findById(appointmentDetailDTO.getAppDetailsId());
        if (detailOptional.isPresent()) {
            // Fetch the Appointment by ID
            Appointment appointment = appointmentRepo.findById(appointmentDetailDTO.getAppointmentId())
                    .orElseThrow(() -> new EntityNotFoundException("Appointment not found"));

            // Convert DTO to AppointmentDetail entity and update it
            AppointmentDetail appointmentDetail = mappingUtil.appointmentDetailConvertToEntity(appointmentDetailDTO);
            appointmentDetail.setAppointment(appointment); // Set the appointment entity

            appointmentDetailRepo.save(appointmentDetail); // Save the updated appointment detail
        } else {
            throw new EntityNotFoundException("Appointment Detail not found");
        }
    }

    @Override
    public boolean deleteAppointmentDetail(int id) {
        Optional<AppointmentDetail> detailOptional = appointmentDetailRepo.findById(id);
        if (detailOptional.isPresent()) {
            appointmentDetailRepo.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Appointment Detail not found");
        }
    }

    @Override
    public List<AppointmentDetailDTO> getAllAppointmentDetails() {
        return appointmentDetailRepo.findAll().stream()
                .map(mappingUtil::appointmentDetailConvertToDTO)
                .toList();
    }

    @Override
    public AppointmentDetailDTO getAppointmentDetailById(int id) {
        Optional<AppointmentDetail> detailOptional = appointmentDetailRepo.findById(id);
        if (detailOptional.isPresent()) {
            return mappingUtil.appointmentDetailConvertToDTO(detailOptional.get());
        } else {
            throw new EntityNotFoundException("Appointment Detail not found");
        }
    }
}
