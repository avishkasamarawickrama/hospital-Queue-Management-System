package com.example.queue_management_system_hospital.service;

import com.example.queue_management_system_hospital.dto.AppointmentDetailDTO;
import java.util.List;

public interface AppointmentDetailService {

    void addAppointmentDetail(AppointmentDetailDTO appointmentDetailDTO);

    void updateAppointmentDetail(AppointmentDetailDTO appointmentDetailDTO);

    void deleteAppointmentDetail(Long appointmentDetailId);

    List<AppointmentDetailDTO> getAllAppointmentDetails();

    AppointmentDetailDTO getAppointmentDetailById(Long appointmentDetailId);
}
