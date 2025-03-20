package com.example.queue_management_system_hospital.service.impl;

import com.example.queue_management_system_hospital.dto.AppointmentDetailDTO;
import com.example.queue_management_system_hospital.entity.AppointmentDetail;
import com.example.queue_management_system_hospital.repo.AppointmentDetailRepo;
import com.example.queue_management_system_hospital.service.AppointmentDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentDetailServiceImpl implements AppointmentDetailService {

    @Autowired
    private AppointmentDetailRepo appointmentDetailRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addAppointmentDetail(AppointmentDetailDTO appointmentDetailDTO) {
        AppointmentDetail appointmentDetail = modelMapper.map(appointmentDetailDTO, AppointmentDetail.class);
        appointmentDetailRepo.save(appointmentDetail);
    }

    @Override
    public void updateAppointmentDetail(AppointmentDetailDTO appointmentDetailDTO) {
        AppointmentDetail existingAppointmentDetail = appointmentDetailRepo.findById(appointmentDetailDTO.getDetailId())
                .orElseThrow(() -> new RuntimeException("Appointment detail not found: " + appointmentDetailDTO.getDetailId()));

        existingAppointmentDetail.setProcedure(appointmentDetailDTO.getProcedure());
        existingAppointmentDetail.setNotes(appointmentDetailDTO.getNotes());

        appointmentDetailRepo.save(existingAppointmentDetail);
    }

    @Override
    public void deleteAppointmentDetail(Long appointmentDetailId) {
        AppointmentDetail appointmentDetail = appointmentDetailRepo.findById(appointmentDetailId)
                .orElseThrow(() -> new RuntimeException("Appointment detail not found: " + appointmentDetailId));

        appointmentDetailRepo.delete(appointmentDetail);
    }

    @Override
    public List<AppointmentDetailDTO> getAllAppointmentDetails() {
        List<AppointmentDetail> appointmentDetails = appointmentDetailRepo.findAll();
        return appointmentDetails.stream()
                .map(appointmentDetail -> modelMapper.map(appointmentDetail, AppointmentDetailDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDetailDTO getAppointmentDetailById(Long appointmentDetailId) {
        AppointmentDetail appointmentDetail = appointmentDetailRepo.findById(appointmentDetailId)
                .orElseThrow(() -> new RuntimeException("Appointment detail not found: " + appointmentDetailId));

        return modelMapper.map(appointmentDetail, AppointmentDetailDTO.class);
    }
}
