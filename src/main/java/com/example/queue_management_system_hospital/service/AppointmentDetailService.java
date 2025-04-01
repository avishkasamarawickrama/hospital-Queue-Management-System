package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.AppointmentDetailDTO;

import java.util.List;

public interface AppointmentDetailService {
    void addAppointmentDetail(AppointmentDetailDTO appointmentDetail);
    void updateAppointmentDetail(AppointmentDetailDTO appointmentDetail);
    boolean deleteAppointmentDetail(int id);
    List<AppointmentDetailDTO> getAllAppointmentDetails();
    AppointmentDetailDTO getAppointmentDetailById(int id);
}
