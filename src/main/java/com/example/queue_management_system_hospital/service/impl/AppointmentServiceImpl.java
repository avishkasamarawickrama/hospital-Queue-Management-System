//package com.example.queue_management_system_hospital.service.impl;
//
//import com.example.queue_management_system_hospital.dto.AppointmentDTO;
//import com.example.queue_management_system_hospital.entity.Appointment;
//import com.example.queue_management_system_hospital.entity.Doctor;
//import com.example.queue_management_system_hospital.entity.Patient;
//import com.example.queue_management_system_hospital.repo.*;
//import com.example.queue_management_system_hospital.service.AppointmentService;
//import jakarta.transaction.Transactional;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.List;
//
//@Service
//@Transactional
//public class AppointmentServiceImpl implements AppointmentService {
//
//    @Autowired
//    private AppointmentRepo appointmentRepo;
//
//    @Autowired
//    private PatientRepo patientRepo;
//
//    @Autowired
//    private DoctorRepo doctorRepo;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Override
//    @Transactional
//    public void addAppointment(AppointmentDTO appointmentDTO) {
//
//        Appointment appointment = new Appointment();
//        appointment.setAppointment_id(appointmentDTO.getAppointment_id());
//        appointment.setAppointment_date(appointmentDTO.getAppointment_date());
//
//        Patient patient = patientRepo.findById(appointmentDTO.getPatient_id())
//                .orElseThrow(() -> new RuntimeException("patient not found: " + orderDTO.getCustomerId()));
//
//        appointment.setPatient(patient);
//
//        appointment.setQueue_numberber(appointmentDTO.getQueue_number());
//
//        Appointment savedAppointment = appointmentRepo.save(appointment);
//
//        List<AppointmentDetailDTO> AppointmentDetailsList = appointmentDTO.getOrderDetails();
//
//        for (AppointmentDTO appointmentDetailDTO : appointmentDetailsList) {
//            Doctor doctor = doctorRepo.findById(appointmentDTO.getDoctor_id())
//                    .orElseThrow(() -> new RuntimeException("doctor not found: " + appointmentDetailDTO.getDoctor_id()));
//
//            AppointmentDetail orderDetail = new OrderDetail();
//            orderDetail.setOrder(savedOrder);
//            orderDetail.setItem(item);
//            orderDetail.setQuantity(orderDetailDTO.getQuantity());
//            orderDetail.setTotal(orderDetailDTO.getTotal());
//
//            orderDetailRepo.save(orderDetail);
//
//            itemRepo.updateQty(item.getCode(),orderDetailDTO.getQuantity());
//
//        }
//    }
//
//    @Override
//    public List<OrderDetailDTO> getOrderDetails() {
//        return modelMapper.map(orderDetailRepo.findAll(),
//                new TypeToken<List<OrderDetailDTO>>(){}.getType());
//
//    }
//
//}
