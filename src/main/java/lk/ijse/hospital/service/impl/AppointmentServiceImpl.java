package lk.ijse.hospital.service.impl;

import lk.ijse.hospital.dto.AppointmentDTO;
import lk.ijse.hospital.entity.*;
import lk.ijse.hospital.repo.AppointmentRepo;
import lk.ijse.hospital.repo.DoctorRepo;
import lk.ijse.hospital.repo.PatientRepo;
import lk.ijse.hospital.service.AppointmentService;
import lk.ijse.hospital.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResponseUtil saveAppointment(AppointmentDTO appointmentDTO) {
        try {
            Doctor doctor = doctorRepo.findById(appointmentDTO.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));

            Patient patient = patientRepo.findById(appointmentDTO.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));

            // Check if time slot is available
            if (appointmentRepo.existsByDoctorAndAppointmentDateAndAppointmentTime(
                    doctor,
                    appointmentDTO.getAppointmentDate(),
                    appointmentDTO.getAppointmentTime())) {
                return new ResponseUtil(400, "Time slot already booked", null);
            }

            // Check if max appointments reached for this doctor on this date
            int appointmentCount = appointmentRepo.countByDoctorAndAppointmentDate(
                    doctor,
                    appointmentDTO.getAppointmentDate());

            if (appointmentCount >= doctor.getMaxAppointmentsPerDay()) {
                return new ResponseUtil(400, "Doctor's schedule is full for this day", null);
            }

            // Generate appointment ID
            String nextAppointmentId = generateNextAppointmentId();

            // Calculate queue number for this doctor on this date
            Integer maxQueue = appointmentRepo.findMaxQueueNumberByDoctorAndAppointmentDate(
                    doctor,
                    appointmentDTO.getAppointmentDate());

            int queueNumber = maxQueue != null ? maxQueue + 1 : 1;

            Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
            appointment.setAppointmentId(Integer.valueOf(nextAppointmentId));
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            appointment.setQueueNumber(queueNumber);
            appointment.setStatus(Appointment.AppointmentStatus.PENDING);
            appointment.setPaymentStatus(Appointment.PaymentStatus.PENDING);

            Appointment savedAppointment = appointmentRepo.save(appointment);

            return new ResponseUtil(200, "Appointment Saved Successfully",
                    modelMapper.map(savedAppointment, AppointmentDTO.class));

        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    private String generateNextAppointmentId() {
        // Get the last appointment ID from database
        Appointment lastAppointment = appointmentRepo.findTopByOrderByCreatedAtDesc();

        if (lastAppointment == null) {
            return "APT-00001"; // First appointment
        }

        // Extract numeric part and increment
        String lastId = String.valueOf(lastAppointment.getAppointmentId());
        int lastNum = Integer.parseInt(lastId.split("-")[1]);
        return String.format("APT-%05d", lastNum + 1);
    }

    @Override
    public ResponseUtil updateAppointment(AppointmentDTO appointmentDTO) {
        try {
            if (!appointmentRepo.existsById(appointmentDTO.getAppointmentId())) {
                return new ResponseUtil(404, "Appointment not found", null);
            }

            Doctor doctor = doctorRepo.findById(appointmentDTO.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));

            Patient patient = patientRepo.findById(appointmentDTO.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));

            Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            appointmentRepo.save(appointment);

            return new ResponseUtil(200, "Appointment Updated Successfully", null);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @Override
    public ResponseUtil deleteAppointment(Integer appointmentId) {
        try {
            appointmentRepo.deleteById(appointmentId);
            return new ResponseUtil(200, "Appointment Deleted Successfully", null);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @Override
    public ResponseUtil getAllAppointments() {
        try {
            List<AppointmentDTO> appointmentList = modelMapper.map(
                    appointmentRepo.findAll(),
                    new TypeToken<List<AppointmentDTO>>() {}.getType());
            return new ResponseUtil(200, "Success", appointmentList);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @Override
    public ResponseUtil getAppointmentById(Integer appointmentId) {
        try {
            Appointment appointment = appointmentRepo.findById(appointmentId)
                    .orElseThrow(() -> new RuntimeException("Appointment not found"));

            AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
            appointmentDTO.setDoctorName(appointment.getDoctor().getFullName());
            appointmentDTO.setPatientName(appointment.getPatient().getFullName());
            appointmentDTO.setDepartmentName(appointment.getDoctor().getDepartmentName());

            return new ResponseUtil(200, "Success", appointmentDTO);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @Override
    public ResponseUtil getAppointmentsByDate(LocalDate date) {
        try {
            List<AppointmentDTO> appointmentList = modelMapper.map(
                    appointmentRepo.findByAppointmentDate(date),
                    new TypeToken<List<AppointmentDTO>>() {}.getType());
            return new ResponseUtil(200, "Success", appointmentList);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @Override
    public ResponseUtil getAppointmentsByDoctorAndDate(Integer doctorId, LocalDate date) {
        try {
            List<AppointmentDTO> appointmentList = modelMapper.map(
                    appointmentRepo.findByDoctorDoctorIdAndAppointmentDate(doctorId, date),
                    new TypeToken<List<AppointmentDTO>>() {}.getType());
            return new ResponseUtil(200, "Success", appointmentList);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @Override
    public ResponseUtil getAppointmentsByPatient(String patientId) {
        try {
            List<AppointmentDTO> appointmentList = modelMapper.map(
                    appointmentRepo.findByPatientPatientId(patientId),
                    new TypeToken<List<AppointmentDTO>>() {}.getType());
            return new ResponseUtil(200, "Success", appointmentList);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @Override
    public ResponseUtil getNextAppointmentId() {
        try {
            Appointment lastAppointment = appointmentRepo.findTopByOrderByAppointmentIdDesc();
            int nextId = lastAppointment != null ? lastAppointment.getAppointmentId() + 1 : 1;
            return new ResponseUtil(200, "Success", nextId);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    @Override
    public ResponseUtil getAvailableTimeSlots(Integer doctorId, LocalDate date) {
        try {
            Doctor doctor = doctorRepo.findById(doctorId)
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));

            // Get existing appointments for the doctor on this date
            List<Appointment> existingAppointments = appointmentRepo.findByDoctorDoctorIdAndAppointmentDate(doctorId, date);

            // Generate all possible time slots for the doctor's working hours
            List<LocalTime> allSlots = generateTimeSlots(
                    doctor.getAvailableFrom(),
                    doctor.getAvailableTo(),
                    30); // 30 minute intervals

            // Filter out booked slots
            existingAppointments.forEach(appointment ->
                    allSlots.remove(appointment.getAppointmentTime()));

            return new ResponseUtil(200, "Available time slots", allSlots);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }

    private List<LocalTime> generateTimeSlots(LocalTime start, LocalTime end, int intervalMinutes) {
        List<LocalTime> slots = new java.util.ArrayList<>();
        LocalTime current = start;

        while (current.isBefore(end)) {
            slots.add(current);
            current = current.plusMinutes(intervalMinutes);
        }

        return slots;
    }
    @Override
    public Appointment updateAppointmentStatus(Integer appointmentId, String status, String paymentStatus) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        if (status != null) {
            try {
                appointment.setStatus(Appointment.AppointmentStatus.valueOf(status));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid appointment status: " + status);
            }
        }

        if (paymentStatus != null) {
            try {
                appointment.setPaymentStatus(Appointment.PaymentStatus.valueOf(paymentStatus));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid payment status: " + paymentStatus);
            }
        }

        return appointmentRepo.save(appointment);
    }
}