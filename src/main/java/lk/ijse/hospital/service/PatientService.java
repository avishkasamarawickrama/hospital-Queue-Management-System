package lk.ijse.hospital.service;

import lk.ijse.hospital.dto.PatientDTO;
import java.util.List;

public interface PatientService {
    void addPatient(PatientDTO patientDTO);
    void updatePatient(PatientDTO patientDTO);
    void deletePatient(String id);
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(String id);
    String generateNextPatientId();
    String generateNextUserId();
}