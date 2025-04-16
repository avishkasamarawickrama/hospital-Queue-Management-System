package lk.ijse.hospital.repo;

import lk.ijse.hospital.entity.Appointment;
import lk.ijse.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// AppointmentRepo.java - Fix repository methods
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    @Query("SELECT MAX(a.queueNumber) FROM Appointment a WHERE a.appointmentDate = :date AND a.doctor.doctorId = :doctorId")
    Integer findMaxQueueNumberByDateAndDoctor(LocalDate date, Integer doctorId);

    List<Appointment> findByAppointmentDate(LocalDate date);

    List<Appointment> findByDoctorDoctorIdAndAppointmentDate(Integer doctorId, LocalDate date);

    List<Appointment> findByPatientPatientId(String patientId);

    @Query("SELECT a FROM Appointment a ORDER BY a.appointmentId DESC LIMIT 1")
    Appointment findLatestAppointment();

    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.appointmentDate = :date AND a.doctor.doctorId = :doctorId")
    Integer countByDoctorAndDate(Integer doctorId, LocalDate date);

    @Query("SELECT a FROM Appointment a WHERE a.doctor.doctorId = :doctorId AND a.appointmentDate = :date AND a.appointmentTime = :time")
    Appointment findByDoctorDateAndTime(Integer doctorId, LocalDate date, LocalTime time);


    int countByDoctorAndAppointmentDate(Doctor doctor, LocalDate date);

    Integer findMaxQueueNumberByDoctorAndAppointmentDate(
            Doctor doctor, LocalDate date);

    Appointment findTopByOrderByAppointmentIdDesc();

    // In AppointmentRepo.java
    List<Appointment> findByStatus(Appointment.AppointmentStatus status);

    List<Appointment> findByDoctorDoctorIdAndAppointmentDateAndStatus(Integer doctorId, LocalDate date, Appointment.AppointmentStatus status);

    List<Appointment> findByDoctorDoctorId(Integer doctorId);
    @Query("SELECT MAX(a.appointmentId) FROM Appointment a")
    Integer findMaxAppointmentId();
    boolean existsByDoctorAndAppointmentDateAndAppointmentTime(Doctor doctor, LocalDate appointmentDate, LocalTime appointmentTime);
}
