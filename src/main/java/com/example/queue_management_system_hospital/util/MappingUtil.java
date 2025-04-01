package com.example.queue_management_system_hospital.util;

import com.example.queue_management_system_hospital.dto.*;
import com.example.queue_management_system_hospital.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.List;

@Component
public class MappingUtil {
    @Autowired
    private ModelMapper modelMapper;

    public DepartmentDTO departmentConvertToDTO(Department department) {
        return modelMapper.map(department, DepartmentDTO.class);
    }

    public Department departmentConvertToEntity(DepartmentDTO departmentDTO) {
        return modelMapper.map(departmentDTO, Department.class);
    }

    public List<DepartmentDTO> departmentListConvertToDTOList(List<Department> departments) {
        return departments.stream().map(this::departmentConvertToDTO).toList();
    }
    public PatientDTO patientConvertToDTO(Patient patient) {
        return modelMapper.map(patient, PatientDTO.class);
    }

    public Patient patientConvertToEntity(PatientDTO patientDTO) {
        return modelMapper.map(patientDTO, Patient.class);
    }

    public List<PatientDTO> patientListConvertToDTOList(List<Patient> patients) {
        return patients.stream().map(this::patientConvertToDTO).toList();
    }

    public DoctorDTO doctorConvertToDTO(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    public Doctor doctorConvertToEntity(DoctorDTO doctorDTO) {
        return modelMapper.map(doctorDTO, Doctor.class);
    }

    public List<DoctorDTO> doctorListConvertToDTOList(List<Doctor> doctors) {
        return doctors.stream().map(this::doctorConvertToDTO).toList();
    }

    public AppointmentDTO appointmentConvertToDTO(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getAppointmentId(),
                appointment.getDoctor().getDoctorId(),   // Extracting doctorId
                appointment.getPatient().getPatientId(),  // Extracting patientId
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getQueueNumber(),
                appointment.getStatus(),
                appointment.getPaymentStatus(),
                appointment.getChannelingFee(),
                appointment.getDoctor().getDepartment().getDepartmentName() // Fetching department name
        );
    }

    public Appointment appointmentConvertToEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);

        Doctor doctor = new Doctor();
        doctor.setDoctorId(appointmentDTO.getDoctorId()); // Ensure correct foreign key mapping
        appointment.setDoctor(doctor);

        Patient patient = new Patient();
        patient.setPatientId(appointmentDTO.getPatientId()); // Ensure correct foreign key mapping
        appointment.setPatient(patient);

        return appointment;
    }


    public List<AppointmentDTO> appointmentListConvertToDTOList(List<Appointment> appointments) {
        return appointments.stream().map(this::appointmentConvertToDTO).toList();
    }


    public AppointmentDetailDTO appointmentDetailConvertToDTO(AppointmentDetail appointmentDetail) {
        return modelMapper.map(appointmentDetail, AppointmentDetailDTO.class);
    }

    public AppointmentDetail appointmentDetailConvertToEntity(AppointmentDetailDTO appointmentDetailDTO) {
        return modelMapper.map(appointmentDetailDTO, AppointmentDetail.class);
    }

    public List<AppointmentDetailDTO> appointmentDetailListConvertToDTOList(List<AppointmentDetail> appointmentDetails) {
        return appointmentDetails.stream().map(this::appointmentDetailConvertToDTO).toList();
    }

}
