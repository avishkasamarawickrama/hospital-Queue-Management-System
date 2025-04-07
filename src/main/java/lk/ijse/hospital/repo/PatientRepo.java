package lk.ijse.hospital.repo;

import lk.ijse.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, String> {
    @Query(value = "SELECT patient_id FROM patient ORDER BY patient_id DESC LIMIT 1", nativeQuery = true)
    String getLastPatientId();

    @Query(value = "SELECT uid FROM systemuser ORDER BY uid DESC LIMIT 1", nativeQuery = true)
    String getLastUserId();

    boolean existsByFullName(String fullName);

    @Query("SELECT p FROM Patient p ORDER BY p.patientId DESC LIMIT 1")
    Patient findTopByOrderByPatientIdDesc();
}