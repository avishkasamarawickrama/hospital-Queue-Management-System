package lk.ijse.hospital.repo;

import lk.ijse.hospital.entity.Appointment;
import lk.ijse.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    @Query("SELECT MAX(a.queueNumber) FROM Appointment a WHERE a.appointmentDate = :date AND a.doctor.doctorId = :doctorId")
    Integer findMaxQueueNumberByDateAndDoctor(LocalDate date, Integer doctorId);

    List<Appointment> findByAppointmentDate(LocalDate date);

    List<Appointment> findByDoctorDoctorIdAndAppointmentDate(Integer doctorId, LocalDate date);

    List<Appointment> findByPatientPatientId(String patientId);

    @Query("SELECT a FROM Appointment a ORDER BY a.appointmentId DESC LIMIT 1")
    Appointment findTopByOrderByAppointmentIdDesc();

    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.appointmentDate = :date AND a.doctor.doctorId = :doctorId")
    Integer countByDoctorAndDate(Integer doctorId, LocalDate date);

    @Query("SELECT a FROM Appointment a WHERE a.doctor.doctorId = :doctorId AND a.appointmentDate = :date AND a.appointmentTime = :time")
    Appointment findByDoctorDateAndTime(Integer doctorId, LocalDate date, LocalTime time);

    boolean existsByDoctorAndAppointmentDateAndAppointmentTime(
            Doctor doctor, LocalDate date, LocalTime time);

    int countByDoctorAndAppointmentDate(Doctor doctor, LocalDate date);

    Integer findMaxQueueNumberByDoctorAndAppointmentDate(
            Doctor doctor, LocalDate date);

    Appointment findTopByOrderByCreatedAtDesc();
}