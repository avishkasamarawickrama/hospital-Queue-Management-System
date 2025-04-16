package lk.ijse.hospital.controller;

import lk.ijse.hospital.dto.AppointmentDTO;
import lk.ijse.hospital.dto.AppointmentStatusUpdateRequest;
import lk.ijse.hospital.dto.ResponseDTO;
import lk.ijse.hospital.entity.Appointment;
import lk.ijse.hospital.repo.AppointmentRepo;
import lk.ijse.hospital.service.AppointmentService;
import lk.ijse.hospital.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*")
@RequestMapping("api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepo appointmentRepo;




    @GetMapping("filter")
    public ResponseUtil filterAppointments(
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) Integer doctorId,
            @RequestParam(required = false) String status) {

        return appointmentService.filterAppointments(date, doctorId, status);
    }

    @GetMapping("nextId")
    public ResponseUtil getNextAppointmentId() {
        try {
            // Get the highest current ID and add 1
            Integer lastId = appointmentRepo.findMaxAppointmentId();
            int nextId = (lastId != null) ? lastId + 1 : 1;
            return new ResponseUtil(200, "Success", nextId);
        } catch (Exception e) {
            return new ResponseUtil(500, e.getMessage(), null);
        }
    }
    @PostMapping("save")
    public ResponseEntity<ResponseDTO> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        try {
            ResponseUtil savedAppointment = appointmentService.saveAppointment(appointmentDTO);
            return ResponseEntity.ok(
                    ResponseDTO.builder()
                            .code(200)
                            .message("Appointment Saved Successfully")
                            .data(savedAppointment.getData()) // Make sure this includes all required fields
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDTO.builder()
                            .code(400)
                            .message(e.getMessage())
                            .build()
            );
        }
    }

    @PutMapping("update")
    public ResponseUtil updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.updateAppointment(appointmentDTO);
    }

    @DeleteMapping("delete/{appointmentId}")
    public ResponseUtil deleteAppointment(@PathVariable Integer appointmentId) {
        return appointmentService.deleteAppointment(appointmentId);
    }

    @GetMapping("getAll")
    public ResponseUtil getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("getAppointment/{appointmentId}")
    public ResponseUtil getAppointmentById(@PathVariable Integer appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @GetMapping("getByDate/{date}")
    public ResponseUtil getAppointmentsByDate(@PathVariable LocalDate date) {
        return appointmentService.getAppointmentsByDate(date);
    }

    @GetMapping("getByDoctorAndDate/{doctorId}/{date}")
    public ResponseUtil getAppointmentsByDoctorAndDate(
            @PathVariable Integer doctorId,
            @PathVariable LocalDate date) {
        return appointmentService.getAppointmentsByDoctorAndDate(doctorId, date);
    }

    @GetMapping("getByPatient/{patientId}")
    public ResponseUtil getAppointmentsByPatient(@PathVariable String patientId) {
        return appointmentService.getAppointmentsByPatient(patientId);
    }

    @GetMapping("getAvailableSlots")
    public ResponseUtil getAvailableTimeSlots(
            @RequestParam Integer doctorId,
            @RequestParam LocalDate date) {
        return appointmentService.getAvailableTimeSlots(doctorId, date);
    }

    @PutMapping("/updateStatus/{appointmentId}")
    public ResponseEntity<ResponseDTO> updateAppointmentStatus(
            @PathVariable Integer appointmentId,
            @RequestBody AppointmentStatusUpdateRequest request) {

        Appointment updatedAppointment = appointmentService.updateAppointmentStatus(
                appointmentId,
                request.getStatus(),
                request.getPaymentStatus()
        );

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(200)
                        .message("Appointment status updated")
                        .data(updatedAppointment)
                        .build(),
                HttpStatus.OK
        );
    }

}