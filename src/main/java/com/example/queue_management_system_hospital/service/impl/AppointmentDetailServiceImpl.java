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
    @Override
    public void addAppointmentDetail(AppointmentDetailDTO appointmentDetailDTO) {

    }

    @Override
    public void updateAppointmentDetail(AppointmentDetailDTO appointmentDetailDTO) {

    }

    @Override
    public void deleteAppointmentDetail(Long appointmentDetailId) {

    }

    @Override
    public List<AppointmentDetailDTO> getAllAppointmentDetails() {
        return List.of();
    }

    @Override
    public AppointmentDetailDTO getAppointmentDetailById(Long appointmentDetailId) {
        return null;
    }
}
